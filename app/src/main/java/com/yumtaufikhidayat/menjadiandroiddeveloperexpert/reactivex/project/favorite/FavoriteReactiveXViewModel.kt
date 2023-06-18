package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.favorite

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.domain.usecase.TourismUseCase
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.usecase.TourismReactiveXUseCase

class FavoriteReactiveXViewModel(
    tourismUseCase: TourismReactiveXUseCase
) : ViewModel() {
    val favoriteTourism = tourismUseCase.getFavoriteTourism()
}