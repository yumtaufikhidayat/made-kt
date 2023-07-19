package com.yumtaufikhidayat.rickandmortys.core.di.dfm

import com.yumtaufikhidayat.rickandmortys.core.domain.usecase.CharacterImpl
import com.yumtaufikhidayat.rickandmortys.core.domain.usecase.CharacterUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterUseCaseModule {
    @Binds
    abstract fun provideCharacterUseCase(characterImpl: CharacterImpl): CharacterUseCase
}