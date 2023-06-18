package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.repository

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.ResourceReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.model.TourismReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.usecase.TourismReactiveXUseCase
import io.reactivex.Flowable

class TourismReactiveXInteractor(private val tourismRepository: ITourismReactiveXRepository) : TourismReactiveXUseCase {
    override fun getAllTourism(): Flowable<ResourceReactiveX<List<TourismReactiveX>>> {
        return tourismRepository.getAllTourism()
    }

    override fun getFavoriteTourism(): Flowable<List<TourismReactiveX>> {
        return tourismRepository.getFavoriteTourism()
    }

    override fun setFavoriteTourism(tourism: TourismReactiveX, state: Boolean) {
        return tourismRepository.setFavoriteTourism(tourism, state)
    }
}