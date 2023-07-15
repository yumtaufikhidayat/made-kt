package com.yumtaufikhidayat.rickandmortys.core.di

import android.content.Context
import androidx.room.Room
import com.yumtaufikhidayat.rickandmortys.core.data.source.local.room.CharacterDao
import com.yumtaufikhidayat.rickandmortys.core.data.source.local.room.CharacterDatabase
import com.yumtaufikhidayat.rickandmortys.core.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): CharacterDatabase = Room.databaseBuilder(
        context,
        CharacterDatabase::class.java, Constants.DB_NAME
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: CharacterDatabase): CharacterDao = database.characterDao()
}