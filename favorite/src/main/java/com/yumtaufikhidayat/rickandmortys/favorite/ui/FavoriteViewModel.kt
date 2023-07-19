package com.yumtaufikhidayat.rickandmortys.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yumtaufikhidayat.rickandmortys.core.domain.usecase.CharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    characterUseCase: CharacterUseCase
) : ViewModel() {
    val favoriteCharacter = characterUseCase.getFavoriteCharacter().asLiveData()
}