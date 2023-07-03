package com.yumtaufikhidayat.made.model.genres


import com.google.gson.annotations.SerializedName

data class GenresResponse(
    @SerializedName("genres")
    val genres: List<Genre> = listOf()
)