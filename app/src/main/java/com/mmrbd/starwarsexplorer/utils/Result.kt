package com.mmrbd.starwarsexplorer.utils

import com.mmrbd.starwarsexplorer.data.remote.error.Failure

/**
 * A wrapper for network request handling failing requests
 * @param data
 * @param error
 * */
sealed class Result<T>(
    val data: T? = null,
    val error: Failure? = null
) {
    class Success<T>(data: T) : Result<T>(data)
    class Loading<T>(data: T? = null) : Result<T>(data)
    class Error<T>(val throwable: Failure, data: T? = null) : Result<T>(data, throwable)
}
