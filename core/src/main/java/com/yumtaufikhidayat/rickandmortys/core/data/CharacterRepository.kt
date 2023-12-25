package com.yumtaufikhidayat.rickandmortys.core.data

import com.yumtaufikhidayat.rickandmortys.core.data.source.local.LocalDataSource
import com.yumtaufikhidayat.rickandmortys.core.data.source.remote.RemoteDataSource
import com.yumtaufikhidayat.rickandmortys.core.data.source.remote.network.ApiResponse
import com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response.CharacterResult
import com.yumtaufikhidayat.rickandmortys.core.domain.model.Character
import com.yumtaufikhidayat.rickandmortys.core.domain.repository.ICharacterRepository
import com.yumtaufikhidayat.rickandmortys.core.utils.AppExecutors
import com.yumtaufikhidayat.rickandmortys.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): ICharacterRepository {
    override fun getAllCharacters(): Flow<Resource<List<Character>>> {
        return object : NetworkBoundResource<List<Character>, List<CharacterResult>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Character>> {
                return localDataSource.getAllCharacters().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Character>?): Boolean {
                return data.isNullOrEmpty()
            }

            override fun createCall(): Flow<ApiResponse<List<CharacterResult>>> {
                return remoteDataSource.getAllCharacters()
            }

            override suspend fun saveCallResult(data: List<CharacterResult>) {
                val characterList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertCharacter(characterList)
            }
        }.asFlow()
    }

    override fun getFavoriteCharacter(): Flow<List<Character>> {
        return localDataSource.getFavoriteCharacter().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteCharacter(character: Character, isFavorite: Boolean) {
        val characterEntity = DataMapper.mapDomainToEntity(character)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteCharacter(characterEntity, isFavorite)
        }
    }
}