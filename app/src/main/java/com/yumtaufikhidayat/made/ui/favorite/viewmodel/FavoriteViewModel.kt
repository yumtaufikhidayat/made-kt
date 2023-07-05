package com.yumtaufikhidayat.made.ui.favorite.viewmodel

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.made.data.repository.MoviesXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: MoviesXRepository) : ViewModel() {

}