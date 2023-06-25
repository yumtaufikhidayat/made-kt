package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.usecase.TourismReactiveXUseCase

class HomeReactiveXViewModel(
    tourismUseCase: TourismReactiveXUseCase
) : ViewModel() {
    val tourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getAllTourism())
}