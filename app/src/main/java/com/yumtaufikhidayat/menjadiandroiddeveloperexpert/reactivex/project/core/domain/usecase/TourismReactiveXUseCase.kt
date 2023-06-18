package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.usecase

import androidx.lifecycle.LiveData
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.Resource
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.ResourceReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.model.TourismReactiveX

interface TourismReactiveXUseCase {

    fun getAllTourism(): LiveData<ResourceReactiveX<List<TourismReactiveX>>>

    fun getFavoriteTourism(): LiveData<List<TourismReactiveX>>

    fun setFavoriteTourism(tourism: TourismReactiveX, state: Boolean)
}