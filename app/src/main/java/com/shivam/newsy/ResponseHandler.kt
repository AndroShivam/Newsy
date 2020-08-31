package com.shivam.newsy

import java.io.IOException

class ResponseHandler {

    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleError(error: Exception): Resource<T> {
        return when (error) {
            is IOException -> Resource.error(ErrorType.NetworkError, null)
            else -> Resource.error(ErrorType.GenericError(error.message), null)
        }
    }
}