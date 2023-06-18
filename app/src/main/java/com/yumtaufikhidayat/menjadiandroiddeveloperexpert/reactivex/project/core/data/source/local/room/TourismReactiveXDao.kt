package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.local.entity.TourismReactiveXEntity

@Dao
interface TourismReactiveXDao {
    @Query("SELECT * FROM tourism")
    fun getAllTourism(): LiveData<List<TourismReactiveXEntity>>

    @Query("SELECT * FROM tourism where isFavorite = 1")
    fun getFavoriteTourism(): LiveData<List<TourismReactiveXEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTourism(tourism: List<TourismReactiveXEntity>)

    @Update
    fun updateFavoriteTourism(tourism: TourismReactiveXEntity)
}