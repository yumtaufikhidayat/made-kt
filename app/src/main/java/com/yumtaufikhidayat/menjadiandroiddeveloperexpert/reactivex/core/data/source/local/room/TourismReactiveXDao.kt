package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.local.entity.TourismReactiveXEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface TourismReactiveXDao {
    @Query("SELECT * FROM tourism")
    fun getAllTourism(): Flowable<List<TourismReactiveXEntity>>

    @Query("SELECT * FROM tourism where isFavorite = 1")
    fun getFavoriteTourism(): Flowable<List<TourismReactiveXEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTourism(tourism: List<TourismReactiveXEntity>): Completable

    @Update
    fun updateFavoriteTourism(tourism: TourismReactiveXEntity)
}