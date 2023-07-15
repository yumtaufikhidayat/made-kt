package com.yumtaufikhidayat.rickandmortys.core.domain.repository

import com.yumtaufikhidayat.rickandmortys.core.data.Resource
import com.yumtaufikhidayat.rickandmortys.core.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface ICharacterRepository {
    fun getAllCharacters(): Flow<Resource<List<Character>>>

    fun getFavoriteCharacter(): Flow<List<Character>>

    fun setFavoriteCharacter(character: Character, isFavorite: Boolean)
}