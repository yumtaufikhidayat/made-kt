package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.repository

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.ResourceReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.model.TourismReactiveX
import io.reactivex.Flowable

interface ITourismReactiveXRepository {
    fun getAllTourism(): Flowable<ResourceReactiveX<List<TourismReactiveX>>>

    fun getFavoriteTourism(): Flowable<List<TourismReactiveX>>

    fun setFavoriteTourism(tourism: TourismReactiveX, state: Boolean)
}