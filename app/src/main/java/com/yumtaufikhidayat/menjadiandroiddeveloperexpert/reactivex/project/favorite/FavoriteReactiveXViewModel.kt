package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.favorite

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.usecase.TourismReactiveXUseCase

class FavoriteReactiveXViewModel(
    tourismUseCase: TourismReactiveXUseCase
) : ViewModel() {
    val favoriteTourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getFavoriteTourism())
}