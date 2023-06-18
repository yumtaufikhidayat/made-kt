package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.repository

import androidx.lifecycle.LiveData
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.ResourceReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.model.TourismReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.usecase.TourismReactiveXUseCase

class TourismReactiveXInteractor(private val tourismRepository: ITourismReactiveXRepository) : TourismReactiveXUseCase {
    override fun getAllTourism(): LiveData<ResourceReactiveX<List<TourismReactiveX>>> {
        return tourismRepository.getAllTourism()
    }

    override fun getFavoriteTourism(): LiveData<List<TourismReactiveX>> {
        return tourismRepository.getFavoriteTourism()
    }

    override fun setFavoriteTourism(tourism: TourismReactiveX, state: Boolean) {
        return tourismRepository.setFavoriteTourism(tourism, state)
    }
}