package com.yumtaufikhidayat.made.model.movietrailer


import com.google.gson.annotations.SerializedName

data class TrailerResult(
    @SerializedName("id")
    val id: String = "", // 63503fc756b9f7009935165c
    @SerializedName("iso_3166_1")
    val iso31661: String = "", // US
    @SerializedName("iso_639_1")
    val iso6391: String = "", // en
    @SerializedName("key")
    val key: String = "", // n19hk6HdF7k
    @SerializedName("name")
    val name: String = "", // Special Feature 'Technical Challenges'
    @SerializedName("official")
    val official: Boolean = false, // true
    @SerializedName("published_at")
    val publishedAt: String = "", // 2022-10-18T17:00:29.000Z
    @SerializedName("site")
    val site: String = "", // YouTube
    @SerializedName("size")
    val size: Int = 0, // 1080
    @SerializedName("type")
    val type: String = "" // Behind the Scenes
)