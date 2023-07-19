package com.yumtaufikhidayat.rickandmortys.core.di.dfm

import com.yumtaufikhidayat.rickandmortys.core.domain.usecase.CharacterUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun providesCharacterUseCase(): CharacterUseCase
}