package com.yumtaufikhidayat.rickandmortys.core.data.source.remote.network

import com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response.CharacterResponse
import com.yumtaufikhidayat.rickandmortys.ui.utils.Constants
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.GET_CHARACTER)
    suspend fun getAllCharacters(): CharacterResponse
}