package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.detail

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.model.TourismReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.usecase.TourismReactiveXUseCase

class DetailTourismReactiveXViewModel(
    private val tourismUseCase: TourismReactiveXUseCase
) : ViewModel() {
    fun setFavoriteTourism(tourism: TourismReactiveX, newStatus: Boolean) {
        tourismUseCase.setFavoriteTourism(tourism, newStatus)
    }
}