package com.yumtaufikhidayat.rickandmortys.core.utils

import com.yumtaufikhidayat.rickandmortys.core.data.source.local.entity.CharacterEntity
import com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response.CharacterResult
import com.yumtaufikhidayat.rickandmortys.core.domain.model.Character

object DataMapper {
    fun mapResponsesToEntities(input: List<CharacterResult>): List<CharacterEntity> {
        val characterList = ArrayList<CharacterEntity>()
        input.map { result ->
            val character = CharacterEntity(
                id = result.id,
                created = result.created,
                gender = result.gender,
                image = result.image,
                name = result.name,
                species = result.species,
                status = result.status,
                type = result.type,
                url = result.url,
                isFavorite = false
            )
            characterList.add(character)
        }
        return characterList
    }

    fun mapEntitiesToDomain(input: List<CharacterEntity>): List<Character> {
        return input.map {
            Character(
                created = it.created,
                gender = it.gender,
                id = it.id,
                image = it.image,
                name = it.name,
                species = it.species,
                status = it.status,
                type = it.type,
                url = it.url,
                isFavorite = it.isFavorite
            )
        }
    }

    fun mapDomainToEntity(input: Character) = CharacterEntity(
        id = input.id,
        created = input.created,
        gender = input.gender,
        image = input.image,
        name = input.name,
        species = input.species,
        status = input.status,
        type = input.type,
        url = input.url,
        isFavorite = input.isFavorite
    )
}