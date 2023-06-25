package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.local.LocalReactiveXDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.RemoteReactiveXDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.network.ApiResponseReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.response.TourismReactiveXResponse
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.model.TourismReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.repository.ITourismReactiveXRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.utils.AppExecutorsReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.utils.DataMapperReactiveX
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TourismReactiveXRepository private constructor (
    private val remoteDataSource: RemoteReactiveXDataSource,
    private val localDataSource: LocalReactiveXDataSource,
    private val appExecutors: AppExecutorsReactiveX
) : ITourismReactiveXRepository {
    override fun getAllTourism(): Flowable<ResourceReactiveX<List<TourismReactiveX>>> =
        object : NetworkBoundResourceReactiveX<List<TourismReactiveX>, List<TourismReactiveXResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<TourismReactiveX>> {
                return localDataSource.getAllTourism().map {
                    DataMapperReactiveX.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TourismReactiveX>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): Flowable<ApiResponseReactiveX<List<TourismReactiveXResponse>>> {
                return remoteDataSource.getAllTourism()
            }

            override fun saveCallResult(data: List<TourismReactiveXResponse>) {
                val tourismList = DataMapperReactiveX.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getFavoriteTourism(): Flowable<List<TourismReactiveX>> {
        return localDataSource.getFavoriteTourism().map {
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