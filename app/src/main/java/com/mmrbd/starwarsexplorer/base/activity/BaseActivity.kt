package com.mmrbd.starwarsexplorer.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.mmrbd.starwarsexplorer.base.vm.BaseViewModel
import com.mmrbd.starwarsexplorer.utils.AppLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseActivity<ViewState : Any, Binding : ViewBinding> (bindingInflater: (LayoutInflater) -> Binding) :
    BaseBinding<Binding>(bindingInflater) {

    abstract val model: BaseViewModel<ViewState, *>
    private val viewScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        AppLogger.log("BaseActivity")
        model.viewStates()
            .forEach { it.onEach { viewState -> binding?.render(viewState) }.launchIn(viewScope) }
    }

    protected open fun Binding.render(viewState: ViewState) {
        // template
    }

    override fun onDestroy() {
        viewScope.cancel()
        super.onDestroy()
    }


}