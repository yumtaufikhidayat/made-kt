package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.network.ApiResponse
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.local.LocalReactiveXDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.remote.RemoteReactiveXDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.remote.response.TourismReactiveXResponse
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.model.TourismReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.repository.ITourismReactiveXRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.utils.AppExecutorsReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.utils.DataMapperReactiveX

class TourismReactiveXRepository private constructor (
    private val remoteDataSource: RemoteReactiveXDataSource,
    private val localDataSource: LocalReactiveXDataSource,
    private val appExecutors: AppExecutorsReactiveX
) : ITourismReactiveXRepository {
    override fun getAllTourism(): LiveData<ResourceReactiveX<List<TourismReactiveX>>> =
        object : NetworkBoundResourceReactiveX<List<TourismReactiveX>, List<TourismReactiveXResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TourismReactiveX>> {
                return Transformations.map(localDataSource.getAllTourism()) {
                    DataMapperReactiveX.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TourismReactiveX>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TourismReactiveXResponse>>> {
                return remoteDataSource.getAllTourism()
            }

            override fun saveCallResult(data: List<TourismReactiveXResponse>) {
                val tourismList = DataMapperReactiveX.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asLiveData()

    override fun getFavoriteTourism(): LiveData<List<TourismReactiveX>> {
        return Transformations.map(localDataSource.getFavoriteTourism()) {
            DataMapperReactiveX.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTourism(tourism: TourismReactiveX, state: Boolean) {
        val tourismEntity = DataMapperReactiveX.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }

    companion object {
        @Volatile
        private var instance: TourismReactiveXRepository? = null

        fun getInstance(
            remoteData: RemoteReactiveXDataSource,
            localData: LocalReactiveXDataSource,
            appExecutors: AppExecutorsReactiveX
        ): TourismReactiveXRepository =
            instance ?: synchronized(this) {
                instance ?: TourismReactiveXRepository(remoteData, localData, appExecutors)
            }
    }
}