package com.mmrbd.starwarsexplorer.utils.network

import android.content.Context
import com.mmrbd.starwarsexplorer.R
import com.mmrbd.starwarsexplorer.data.remote.error.Failure

interface NetworkFailureMessage {
    fun handleFailure(failure: Failure): String
}

class NetworkFailureMessageImpl(
    private val context: Context
) : NetworkFailureMessage {
    override fun handleFailure(failure: Failure): String {
        return when (failure) {
            is Failure.Exception -> failure.exception.message.toString()
            is Failure.HTTP.BadRequest -> context.getString(R.string.failure_bad_request)
            is Failure.HTTP.CanNotConnectToTheServer -> context.getString(R.string.failure_can_not_connect_to_the_server)
            is Failure.HTTP.Forbidden -> context.getString(R.string.failure_forbidden_request)
            is Failure.HTTP.InternalServerError -> context.getString(R.string.failure_internal_server_error)
            is Failure.HTTP.MethodNotAllowed -> context.getString(R.string.failure_method_not_allowed)
            is Failure.HTTP.NetworkConnection -> context.getString(R.string.failure_no_internet_available)
            is Failure.HTTP.NotFound -> context.getString(R.string.failure_not_found)
            is Failure.HTTP.TooManyRequest -> context.getString(R.string.failure_too_many_request)
            is Failure.HTTP.UnauthorizedError -> context.getString(R.string.failure_unauthorized_error)
            is Failure.FailedToCache -> context.getString(R.string.failure_failed_to_cache)
        }
    }
}