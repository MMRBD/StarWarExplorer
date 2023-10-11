package com.mmrbd.starwarsexplorer.base.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.mmrbd.starwarsexplorer.base.navigation.NavEvent
import com.mmrbd.starwarsexplorer.utils.extensions.safeCollect
import com.mmrbd.starwarsexplorer.utils.extensions.safeCoroutineExceptionHandler
import com.mmrbd.starwarsexplorer.utils.AppLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

abstract class BaseViewModel<BaseViewState : Any, EVENT> : ViewModel() {

    private val className = this::class.simpleName

    private val viewStateMap = mutableMapOf<KClass<BaseViewState>, Flow<BaseViewState>>()
    private val job = SupervisorJob()
    private val bgScope: CoroutineScope = CoroutineScope(Dispatchers.IO + job)

    val navigation = MutableSharedFlow<NavEvent>()

    /**
     * This is for navigation to fragment
     * @param navDirections the direction of fragment
     */
    fun navigate(navDirections: NavDirections) {
        viewModelScope.launch {
            navigation.emit(NavEvent.ToDirection(navDirections))
        }
    }

    /**
     * This is for navigation back
     */
    fun navigateBack() {
        viewModelScope.launch {
            navigation.emit(NavEvent.Back)
        }
    }

    fun viewStates(): Collection<Flow<BaseViewState>> = viewStateMap.values


    abstract fun onTriggerEvent(eventType: EVENT)

    init {
        AppLogger.log("Init $className")
    }

    @Suppress("UNCHECKED_CAST", "DEPRECATION")
    protected inline fun <reified T : BaseViewState> query(noinline flowFactory: () -> Flow<T>) =
        query(
            T::class as KClass<BaseViewState>,
            flowFactory as () -> Flow<BaseViewState>
        )

    protected fun runCommand(completable: suspend () -> Unit) {
        bgScope.launch(
            safeCoroutineExceptionHandler { _, _ ->
            }
        ) {
            completable()
        }
    }

    override fun onCleared() {
        AppLogger.log("ViewModel onCleared:: $className")
        job.cancelChildren()
        super.onCleared()
    }

    @Deprecated("Internal usage only! Visible because of inlining")
    protected fun query(
        viewStateClass: KClass<BaseViewState>,
        flowFactory: () -> Flow<BaseViewState>
    ) {
        if (viewStateMap.contains(viewStateClass)) throw IllegalArgumentException("Flow<${viewStateClass.simpleName}> already registered")

        val viewStatePublisher: MutableSharedFlow<BaseViewState> = MutableSharedFlow(
            replay = 1,
            extraBufferCapacity = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )
        viewStateMap[viewStateClass] = viewStatePublisher

        val baseStateName = viewStateClass.qualifiedName!!.split('.').takeLast(2)[0]

        bgScope.launch(
            safeCoroutineExceptionHandler { _, throwable ->
                AppLogger.log(throwable, "Query ${viewStateClass.qualifiedName} failed")
            }
        ) {
            flowFactory().onEach {
                AppLogger.log(
                    "New emission of $baseStateName.${
                        it.toString().take(LOG_QUERY_ERROR_MAX_CHAR)
                    }"
                )
            }.safeCollect(viewStatePublisher::tryEmit)
        }
    }
}


private const val LOG_QUERY_ERROR_MAX_CHAR = 400