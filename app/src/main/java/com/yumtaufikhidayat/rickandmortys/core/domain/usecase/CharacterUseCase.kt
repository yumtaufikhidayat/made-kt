package com.yumtaufikhidayat.rickandmortys.core.domain.usecase

import com.yumtaufikhidayat.rickandmortys.core.data.Resource
import com.yumtaufikhidayat.rickandmortys.core.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterUseCase {
    fun getAllCharacters(): Flow<Resource<List<Character>>>

    fun getFavoriteCharacter(): Flow<List<Character>>

    fun setFavoriteCharacter(character: Character, isFavorite: Boolean)
}