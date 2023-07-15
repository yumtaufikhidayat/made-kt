package com.yumtaufikhidayat.rickandmortys.core.data.source.remote

import com.yumtaufikhidayat.rickandmortys.core.data.source.remote.network.ApiResponse
import com.yumtaufikhidayat.rickandmortys.core.data.source.remote.network.ApiService
import com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response.CharacterResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
){
    fun getAllCharacters(): Flow<ApiResponse<List<CharacterResult>>> {
        return flow {
            try {
                val response = apiService.getAllCharacters()
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}