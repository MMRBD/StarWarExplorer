package com.mmrbd.starwarsexplorer.extensions

import com.mmrbd.starwarsexplorer.utils.AppLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.isActive
import kotlin.coroutines.coroutineContext

inline fun <T, R> Flow<T>.distinctMap(crossinline transform: suspend (value: T) -> R): Flow<R> =
    distinctUntilChanged().map(transform)

/**
 * Only proceed with the given action if the coroutine has not been cancelled.
 * Necessary because Flow.collect receives items even after coroutine was cancelled
 * https://github.com/Kotlin/kotlinx.coroutines/issues/1265
 */
suspend inline fun <T> Flow<T>.safeCollect(crossinline action: suspend (T) -> Unit) {
    collect {
        if (coroutineContext.isActive) action(it)
    }
}

/** Factory method for MutableSharedFlow with PublishSubject like behaviour */
fun <T> mutableSharedFlow() = MutableSharedFlow<T>(extraBufferCapacity = 1)

/** Factory method for MutableSharedFlow with BehaviorSubject-without-initial-value like behaviour */
fun <T> mutableSharedFlowWithLatest() = MutableSharedFlow<T>(replay = 1, extraBufferCapacity = 1)

/** Shares the chain and replays the latest emission to new subscribers */
fun <T> Flow<T>.shareReplayLatest() =
    shareIn(
        CoroutineScope(
            Dispatchers.IO + safeCoroutineExceptionHandler { _, throwable ->
                AppLogger.log(throwable, "ShareReplayLatest failed")
            }
        ),
        SharingStarted.WhileSubscribed(replayExpirationMillis = 1000), replay = 1
    )

fun <T> Flow<T>.share() =
    shareIn(
        CoroutineScope(
            Dispatchers.IO + safeCoroutineExceptionHandler { _, throwable ->
                AppLogger.log(throwable, "Share failed")
            }
        ),
        SharingStarted.WhileSubscribed(replayExpirationMillis = 0), replay = 0
    )

fun tickerFlow(period: Long, initialDelay: Long = period) = flow {
    delay(initialDelay)
    while (true) {
        emit(Unit)
        delay(period)
    }
}
