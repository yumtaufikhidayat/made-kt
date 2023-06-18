package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.repository

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.ResourceReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.model.TourismReactiveX
import io.reactivex.Flowable

interface ITourismReactiveXRepository {
    fun getAllTourism(): Flowable<ResourceReactiveX<List<TourismReactiveX>>>

    fun getFavoriteTourism(): Flowable<List<TourismReactiveX>>

    fun setFavoriteTourism(tourism: TourismReactiveX, state: Boolean)
}