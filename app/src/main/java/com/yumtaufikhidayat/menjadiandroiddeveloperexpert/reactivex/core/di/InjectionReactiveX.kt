package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.di

import android.content.Context
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.TourismReactiveXRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.local.LocalReactiveXDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.local.room.TourismReactiveXDatabase
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.RemoteReactiveXDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.network.ApiConfigReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.repository.ITourismReactiveXRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.repository.TourismReactiveXInteractor
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.usecase.TourismReactiveXUseCase
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.utils.AppExecutorsReactiveX

object InjectionReactiveX {
    private fun provideRepository(context: Context): ITourismReactiveXRepository {
        val database = TourismReactiveXDatabase.getInstance(context)
        val remoteDataSource = RemoteReactiveXDataSource.getInstance(ApiConfigReactiveX.provideApiService())
        val localDataSource = LocalReactiveXDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutorsReactiveX()

        return TourismReactiveXRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismReactiveXUseCase {
        val repository = provideRepository(context)
        return TourismReactiveXInteractor(repository)
    }
}