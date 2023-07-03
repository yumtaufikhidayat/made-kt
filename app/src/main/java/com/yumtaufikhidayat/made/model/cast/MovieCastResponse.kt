package com.yumtaufikhidayat.made.model.cast


import com.google.gson.annotations.SerializedName

data class MovieCastResponse(
    @SerializedName("cast")
    val cast: List<Cast> = listOf(),
    @SerializedName("crew")
    val crew: List<Crew> = listOf(),
    @SerializedName("id")
    val id: Int = 0 // 985939
)