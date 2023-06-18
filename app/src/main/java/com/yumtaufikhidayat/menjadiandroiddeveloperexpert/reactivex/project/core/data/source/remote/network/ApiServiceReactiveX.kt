package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.remote.network

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.response.ListTourismResponse
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.response.TourismResponse
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.remote.response.ListTourismReactiveXResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceReactiveX {

    @GET(UrlEndpointReactiveX.GET_LIST)
    fun getList(): Call<ListTourismReactiveXResponse>
}