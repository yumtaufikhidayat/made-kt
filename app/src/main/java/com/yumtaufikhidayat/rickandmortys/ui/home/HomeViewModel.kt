package com.yumtaufikhidayat.rickandmortys.ui.home

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.rickandmortys.core.domain.usecase.CharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    characterUseCase: CharacterUseCase
) : ViewModel() {
    val character = characterUseCase.getAllCharacters()
}