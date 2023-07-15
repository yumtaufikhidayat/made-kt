package com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count")
    val count: Int = 0, // 826
    @SerializedName("next")
    val next: String = "", // https://rickandmortyapi.com/api/character?page=2
    @SerializedName("pages")
    val pages: Int = 0, // 42
    @SerializedName("prev")
    val prev: Any = Any() // null
)