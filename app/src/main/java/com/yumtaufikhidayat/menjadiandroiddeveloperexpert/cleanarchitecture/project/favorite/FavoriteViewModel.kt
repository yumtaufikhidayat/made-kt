package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.favorite

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.domain.usecase.TourismUseCase

class FavoriteViewModel(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism()
}