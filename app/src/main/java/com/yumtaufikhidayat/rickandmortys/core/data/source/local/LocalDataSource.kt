package com.yumtaufikhidayat.rickandmortys.core.data.source.local

import com.yumtaufikhidayat.rickandmortys.core.data.source.local.entity.CharacterEntity
import com.yumtaufikhidayat.rickandmortys.core.data.source.local.room.CharacterDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val characterDao: CharacterDao
) {
    fun getAllCharacters(): Flow<List<CharacterEntity>> = characterDao.getAllCharacters()

    fun getFavoriteCharacter(): Flow<List<CharacterEntity>> = characterDao.getFavoriteCharacter()

    suspend fun insertCharacter(characterList: List<CharacterEntity>) =
        characterDao.insertCharacter(characterList)

    fun setFavoriteCharacter(character: CharacterEntity, isFavorite: Boolean) {
        character.isFavorite = isFavorite
        characterDao.updateFavoriteCharacter(character)
    }
}