package com.yumtaufikhidayat.rickandmortys.core.domain.usecase

import com.yumtaufikhidayat.rickandmortys.core.data.Resource
import com.yumtaufikhidayat.rickandmortys.core.domain.model.Character
import com.yumtaufikhidayat.rickandmortys.core.domain.repository.ICharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterInteractor @Inject constructor(private val characterRepository: ICharacterRepository): CharacterUseCase {
    override fun getAllCharacters(): Flow<Resource<List<Character>>> {
        return characterRepository.getAllCharacters()
    }

    override fun getFavoriteCharacter(): Flow<List<Character>> {
        return characterRepository.getFavoriteCharacter()
    }

    override fun setFavoriteCharacter(character: Character, isFavorite: Boolean) {
        return characterRepository.setFavoriteCharacter(character, isFavorite)
    }
}