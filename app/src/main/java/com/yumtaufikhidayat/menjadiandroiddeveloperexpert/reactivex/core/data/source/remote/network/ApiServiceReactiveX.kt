package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.network

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.response.ListTourismReactiveXResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiServiceReactiveX {

    @GET(UrlEndpointReactiveX.GET_LIST)
    fun getList(): Flowable<ListTourismReactiveXResponse>
}