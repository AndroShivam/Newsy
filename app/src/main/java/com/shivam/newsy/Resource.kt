package com.shivam.newsy

data class Resource<out T>(val status: Status, val data: T?, val error: ErrorType?) {

    companion object {
        fun <T> success(data: T?): Resource<T> = Resource(Status.SUCCESS, data, null)
        fun <T> error(msg: ErrorType, data: T?) = Resource(Status.ERROR, data, msg)
        fun <T> loading(data: T?) = Resource(Status.LOADING, data, null)
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

sealed class ErrorType {
    object NetworkError : ErrorType()
    data class GenericError(val msg: String?) : ErrorType()
}