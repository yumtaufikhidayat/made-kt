package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.utils

import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.local.entity.TourismReactiveXEntity
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.data.source.remote.response.TourismReactiveXResponse
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.model.TourismReactiveX

object DataMapperReactiveX {
    fun mapResponsesToEntities(input: List<TourismReactiveXResponse>): List<TourismReactiveXEntity> {
        val tourismList = ArrayList<TourismReactiveXEntity>()
        input.map {
            val tourism = TourismReactiveXEntity(
                tourismId = it.id,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<TourismReactiveXEntity>): List<TourismReactiveX> =
        input.map {
            TourismReactiveX(
                tourismId = it.tourismId,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: TourismReactiveX) = TourismReactiveXEntity(
        tourismId = input.tourismId,
        description = input.description,
        name = input.name,
        address = input.address,
        latitude = input.latitude,
        longitude = input.longitude,
        like = input.like,
        image = input.image,
        isFavorite = input.isFavorite
    )
}