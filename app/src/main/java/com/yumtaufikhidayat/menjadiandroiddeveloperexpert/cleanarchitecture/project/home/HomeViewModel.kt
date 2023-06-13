package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.home

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.domain.usecase.TourismUseCase

class HomeViewModel(
    tourismUseCase: TourismUseCase
) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism()
}