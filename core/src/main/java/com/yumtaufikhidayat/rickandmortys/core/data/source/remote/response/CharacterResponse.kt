package com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    val info: Info = Info(),
    @SerializedName("results")
    val results: List<CharacterResult> = listOf()
)