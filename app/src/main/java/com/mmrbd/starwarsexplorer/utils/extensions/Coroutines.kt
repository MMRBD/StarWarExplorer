package com.mmrbd.starwarsexplorer.utils.extensions

import com.mmrbd.starwarsexplorer.utils.AppLogger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.isActive
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * This method for Exception handling for Coroutine
 * @param handler
 *
 *
*/

inline fun safeCoroutineExceptionHandler(crossinline handler: (CoroutineContext, Throwable) -> Unit): CoroutineExceptionHandler =
    object : AbstractCoroutineContextElement(CoroutineExceptionHandler), CoroutineExceptionHandler {
        override fun handleException(context: CoroutineContext, exception: Throwable) {
            if (context.isActive) handler(context, exception)
            else AppLogger.log("Error occurred but the consumer is no longer active", exception)
        }
    }
