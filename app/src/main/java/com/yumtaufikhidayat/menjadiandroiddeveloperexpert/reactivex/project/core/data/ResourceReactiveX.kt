package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data

sealed class ResourceReactiveX<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : ResourceReactiveX<T>(data)
    class Loading<T>(data: T? = null) : ResourceReactiveX<T>(data)
    class Error<T>(message: String, data: T? = null) : ResourceReactiveX<T>(data, message)
}
