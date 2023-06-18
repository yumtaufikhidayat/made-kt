package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.network.ApiResponse
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.utils.AppExecutors
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.utils.AppExecutorsReactiveX

abstract class NetworkBoundResourceReactiveX<ResultType, RequestType>(private val mExecutors: AppExecutorsReactiveX) {

    private val result = MediatorLiveData<ResourceReactiveX<ResultType>>()

    init {
        result.value = ResourceReactiveX.Loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    result.value = ResourceReactiveX.Success(newData)
                }
            }
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): LiveData<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {

        val apiResponse = createCall()

        result.addSource(dbSource) { newData ->
            result.value = ResourceReactiveX.Loading(newData)
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response) {
                is ApiResponse.Success ->
                    mExecutors.diskIO().execute {
                        saveCallResult(response.data)
                        mExecutors.mainThread().execute {
                            result.addSource(loadFromDB()) { newData ->
                                result.value = ResourceReactiveX.Success(newData)
                            }
                        }
                    }
                is ApiResponse.Empty -> mExecutors.mainThread().execute {
                    result.addSource(loadFromDB()) { newData ->
                        result.value = ResourceReactiveX.Success(newData)
                    }
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    result.addSource(dbSource) { newData ->
                        result.value = ResourceReactiveX.Error(response.errorMessage, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<ResourceReactiveX<ResultType>> = result
}