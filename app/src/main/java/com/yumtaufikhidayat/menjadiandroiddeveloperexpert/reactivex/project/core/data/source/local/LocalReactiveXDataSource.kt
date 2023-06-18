package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.local

import androidx.lifecycle.LiveData
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.local.entity.TourismReactiveXEntity
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.local.room.TourismReactiveXDao

class LocalReactiveXDataSource private constructor(private val tourismDao: TourismReactiveXDao) {

    fun getAllTourism(): LiveData<List<TourismReactiveXEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): LiveData<List<TourismReactiveXEntity>> = tourismDao.getFavoriteTourism()

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