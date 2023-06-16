package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.di

import android.content.Context
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.TourismRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.local.LocalDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.local.room.TourismDatabase
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.RemoteDataSource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.network.ApiConfig
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.domain.repository.ITourismRepository
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.domain.usecase.TourismInteractor
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.domain.usecase.TourismUseCase
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}