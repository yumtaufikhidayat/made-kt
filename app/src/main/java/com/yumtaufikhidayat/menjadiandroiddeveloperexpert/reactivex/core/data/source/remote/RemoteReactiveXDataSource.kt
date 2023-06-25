package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote

import android.util.Log
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.network.ApiResponseReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.network.ApiServiceReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.response.TourismReactiveXResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class RemoteReactiveXDataSource private constructor(
    private val apiService: ApiServiceReactiveX
) {

    fun getAllTourism(): Flowable<ApiResponseReactiveX<List<TourismReactiveXResponse>>> {
        val resultData = PublishSubject.create<ApiResponseReactiveX<List<TourismReactiveXResponse>>>()

        // get data from local JSON
        val client = apiService.getList()
        client.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                val dataArray = response.places
                resultData.onNext(if (dataArray.isNotEmpty()) ApiResponseReactiveX.Success(dataArray) else ApiResponseReactiveX.Empty)
            }, { error ->
                resultData.onNext(ApiResponseReactiveX.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

    companion object {
        @Volatile
        private var instance: RemoteReactiveXDataSource? = null

        fun getInstance(service: ApiServiceReactiveX): RemoteReactiveXDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteReactiveXDataSource(service)
            }
    }
}