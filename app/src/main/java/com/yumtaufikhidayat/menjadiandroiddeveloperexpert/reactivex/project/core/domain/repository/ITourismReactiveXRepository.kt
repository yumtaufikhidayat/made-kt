package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.repository

import androidx.lifecycle.LiveData
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.ResourceReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.model.TourismReactiveX

interface ITourismReactiveXRepository {
    fun getAllTourism(): LiveData<ResourceReactiveX<List<TourismReactiveX>>>

    fun getFavoriteTourism(): LiveData<List<TourismReactiveX>>

    fun setFavoriteTourism(tourism: TourismReactiveX, state: Boolean)
}