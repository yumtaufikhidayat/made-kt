package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.network.ApiResponse
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.remote.network.ApiServiceReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.remote.response.ListTourismReactiveXResponse
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.remote.response.TourismReactiveXResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteReactiveXDataSource private constructor(
    private val apiService: ApiServiceReactiveX
) {

    fun getAllTourism(): LiveData<ApiResponse<List<TourismReactiveXResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<TourismReactiveXResponse>>>()

        // get data from local JSON
        val client = apiService.getList()
        client.enqueue(object : Callback<ListTourismReactiveXResponse> {
            override fun onResponse(
                call: Call<ListTourismReactiveXResponse>,
                response: Response<ListTourismReactiveXResponse>
            ) {
                val dataArray = response.body()?.places
                resultData.value = if (dataArray != null)
                    ApiResponse.Success(dataArray)
                else
                    ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListTourismReactiveXResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
            }
        })

        return resultData
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