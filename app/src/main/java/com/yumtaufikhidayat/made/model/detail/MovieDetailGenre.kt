package com.yumtaufikhidayat.made.model.detail


import com.google.gson.annotations.SerializedName

data class MovieDetailGenre(
    @SerializedName("id")
    val id: Int = 0, // 35
    @SerializedName("name")
    val name: String = "" // Comedy
)