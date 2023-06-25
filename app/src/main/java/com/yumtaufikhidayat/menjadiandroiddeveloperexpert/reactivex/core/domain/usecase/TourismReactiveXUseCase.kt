package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.usecase

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.ResourceReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.model.TourismReactiveX
import io.reactivex.Flowable

interface TourismReactiveXUseCase {

    fun getAllTourism(): Flowable<ResourceReactiveX<List<TourismReactiveX>>>

    fun getFavoriteTourism(): Flowable<List<TourismReactiveX>>

    fun setFavoriteTourism(tourism: TourismReactiveX, state: Boolean)
}