package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.network

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.response.ListTourismResponse
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.response.TourismResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(UrlEndpoint.GET_LIST)
    fun getList(): Call<ListTourismResponse>
}