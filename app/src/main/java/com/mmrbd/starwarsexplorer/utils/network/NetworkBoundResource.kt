package com.mmrbd.starwarsexplorer.utils.network

import com.mmrbd.starwarsexplorer.data.remote.error.Failure
import com.mmrbd.starwarsexplorer.utils.Result
import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {

    val data = query().first()

    //If shouldFetch returns true,
    val resource = if (shouldFetch(data)) {

        //Dispatch a message to the UI that you're doing some background work
        emit(Result.Loading(data))

        try {
            //Make api call for fetch data
            when (val resultType = fetch()) {
                is Result.Error<*> -> {
                    query().map {
                        Result.Error(resultType.throwable, it)
                    }
                }

                else -> {
                    //Save it to the database
                    saveFetchResult(resultType)

                    //Now fetch data again from the database and Dispatch it to the UI
                    query().map { Result.Success(it) }
                }
            }
        } catch (throwable: Throwable) {

            //Dispatch any error emitted to the UI, plus data emitted from the Database
            query().map { Result.Error(Failure.FailedToCache("Failed to cache"), it) }

        }

        //If should fetch returned false
    } else {
        //Make a query to the database and Dispatch it to the UI.
        query().map { Result.Success(it) }
    }

    //Emit the resource variable
    emitAll(resource)
}