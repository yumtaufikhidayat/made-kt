package com.yumtaufikhidayat.made.data

sealed class NetworkResult<out R> private constructor() {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error(val error: String) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()
    data class Unauthorized(val error: String) : NetworkResult<Nothing>()
    data class ServerError(val error: String) : NetworkResult<Nothing>()
}