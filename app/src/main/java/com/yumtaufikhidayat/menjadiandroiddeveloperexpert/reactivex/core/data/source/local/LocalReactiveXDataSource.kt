package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.local

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.local.entity.TourismReactiveXEntity
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.local.room.TourismReactiveXDao
import io.reactivex.Flowable

class LocalReactiveXDataSource private constructor(private val tourismDao: TourismReactiveXDao) {

    fun getAllTourism(): Flowable<List<TourismReactiveXEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): Flowable<List<TourismReactiveXEntity>> = tourismDao.getFavoriteTourism()

    fun insertTourism(tourismList: List<TourismReactiveXEntity>) = tourismDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: TourismReactiveXEntity, newState: Boolean) {
        tourism.isFavorite = newState
        tourismDao.updateFavoriteTourism(tourism)
    }

    companion object {
        private var instance: LocalReactiveXDataSource? = null

        fun getInstance(tourismDao: TourismReactiveXDao): LocalReactiveXDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalReactiveXDataSource(tourismDao)
            }
    }
}