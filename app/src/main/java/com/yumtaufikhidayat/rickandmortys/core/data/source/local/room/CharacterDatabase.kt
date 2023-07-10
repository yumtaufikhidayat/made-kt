package com.yumtaufikhidayat.rickandmortys.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yumtaufikhidayat.rickandmortys.core.data.source.local.entity.CharacterEntity
import com.yumtaufikhidayat.rickandmortys.ui.utils.Constants

@Database(
    entities = [CharacterEntity::class],
    version = Constants.DB_VERSION,
    exportSchema = false
)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}