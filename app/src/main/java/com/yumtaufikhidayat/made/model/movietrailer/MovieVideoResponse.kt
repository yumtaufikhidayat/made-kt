package com.yumtaufikhidayat.made.model.movietrailer


import com.google.gson.annotations.SerializedName

data class MovieVideoResponse(
    @SerializedName("id")
    val id: Int = 0, // 985939
    @SerializedName("results")
    val results: List<TrailerResult> = listOf()
)