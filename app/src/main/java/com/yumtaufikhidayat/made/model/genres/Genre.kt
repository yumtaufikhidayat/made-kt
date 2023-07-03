package com.yumtaufikhidayat.made.model.genres


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int = 0, // 28
    @SerializedName("name")
    val name: String = "" // Action
)