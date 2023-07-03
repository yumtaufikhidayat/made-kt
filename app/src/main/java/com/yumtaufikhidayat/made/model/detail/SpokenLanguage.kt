package com.yumtaufikhidayat.made.model.detail


import com.google.gson.annotations.SerializedName

data class SpokenLanguage(
    @SerializedName("english_name")
    val englishName: String = "", // Turkish
    @SerializedName("iso_639_1")
    val iso6391: String = "", // tr
    @SerializedName("name")
    val name: String = "" // Türkçe
)