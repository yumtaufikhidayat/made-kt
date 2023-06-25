package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.network

sealed class ApiResponseReactiveX<out R> {
    data class Success<out T>(val data: T) : ApiResponseReactiveX<T>()
    data class Error(val errorMessage: String) : ApiResponseReactiveX<Nothing>()
    object Empty : ApiResponseReactiveX<Nothing>()
}
