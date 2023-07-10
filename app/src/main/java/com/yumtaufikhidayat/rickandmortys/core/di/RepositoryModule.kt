package com.yumtaufikhidayat.rickandmortys.core.di

import com.yumtaufikhidayat.rickandmortys.core.data.CharacterRepository
import com.yumtaufikhidayat.rickandmortys.core.domain.repository.ICharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(characterRepository: CharacterRepository): ICharacterRepository
}