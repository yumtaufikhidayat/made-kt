package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.detail

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.domain.model.Tourism
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.domain.usecase.TourismUseCase
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.model.TourismReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.usecase.TourismReactiveXUseCase

class DetailTourismReactiveXViewModel(
    private val tourismUseCase: TourismReactiveXUseCase
) : ViewModel() {
    fun setFavoriteTourism(tourism: TourismReactiveX, newStatus: Boolean) {
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
    }
}