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
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): CharacterDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes(Constants.ENCRYPTED_DB_PASSPHRASE.toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context = context,
            klass = CharacterDatabase::class.java,
            name = Constants.DB_NAME
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory).build()
    }

    @Provides
    fun provideTourismDao(database: CharacterDatabase): CharacterDao = database.characterDao()
}