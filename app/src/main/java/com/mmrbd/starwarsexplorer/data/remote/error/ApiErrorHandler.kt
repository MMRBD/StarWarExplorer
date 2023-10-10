package com.mmrbd.starwarsexplorer.data.remote.error


sealed class Failure {

    data class Exception(val exception: Throwable) : Failure()
    data class FailedToCache(val message: String) : Failure()
    object HTTP {
        object Forbidden : Failure()
        object NotFound : Failure()
        object MethodNotAllowed : Failure()
        object NetworkConnection : Failure()
        object UnauthorizedError : Failure()
        object BadRequest : Failure()
        object CanNotConnectToTheServer : Failure()
        object TooManyRequest : Failure()
        object InternalServerError : Failure()
    }
}

fun getErrorTypeByHTTPCode(httpCode: Int): Failure {
    return when (httpCode) {
        400 -> return Failure.HTTP.BadRequest
        401 -> return Failure.HTTP.UnauthorizedError
        403 -> return Failure.HTTP.Forbidden
        404 -> return Failure.HTTP.NotFound
        405 -> return Failure.HTTP.MethodNotAllowed
        429 -> return Failure.HTTP.TooManyRequest
        in 402..409 -> return Failure.HTTP.CanNotConnectToTheServer
        in 500..599 -> return Failure.HTTP.InternalServerError
        else -> Failure.HTTP.CanNotConnectToTheServer
    }
}