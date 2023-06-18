package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.home

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.domain.usecase.TourismUseCase
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.usecase.TourismReactiveXUseCase

class HomeReactiveXViewModel(
    tourismUseCase: TourismReactiveXUseCase
) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism()
}