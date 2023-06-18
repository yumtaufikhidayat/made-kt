package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.local.entity.TourismReactiveXEntity

@Database(entities = [TourismReactiveXEntity::class], version = 1, exportSchema = false)
abstract class TourismReactiveXDatabase : RoomDatabase() {

    abstract fun tourismDao(): TourismReactiveXDao

    companion object {
        @Volatile
        private var INSTANCE: TourismReactiveXDatabase? = null

        fun getInstance(context: Context): TourismReactiveXDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TourismReactiveXDatabase::class.java,
                    "Tourism.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}