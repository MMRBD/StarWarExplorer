package com.mmrbd.starwarsexplorer.utils

import android.util.Log
import com.mmrbd.starwarsexplorer.BuildConfig

object AppLogger {

    fun log(
        print: String? = "",
        throwable: Throwable? = Throwable(""),
        tag: String? = null
    ) {
        if (BuildConfig.DEBUG) {
            if (throwable?.message?.isNotEmpty() == true) {
                Log.e(tag ?: AppLogger::class.simpleName, print, throwable)
            } else {
                Log.e(tag ?: AppLogger::class.simpleName, "$print")
            }
        } else {
            Log.e(tag ?: AppLogger::class.simpleName, "$print")
        }
    }

    fun log(throwable: Throwable? = Throwable(""), print: String? = "") {
        log(print, throwable)
    }
}