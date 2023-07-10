package com.yumtaufikhidayat.rickandmortys.ui.detail

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.rickandmortys.core.domain.model.Character
import com.yumtaufikhidayat.rickandmortys.core.domain.usecase.CharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {
    fun setFavoriteCharacter(character: Character, isFavorite: Boolean) {
        characterUseCase.setFavoriteCharacter(character, isFavorite)
    }
}