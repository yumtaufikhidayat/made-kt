package com.yumtaufikhidayat.made.model.detail


import com.google.gson.annotations.SerializedName

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val iso31661: String = "", // TR
    @SerializedName("name")
    val name: String = "" // Turkey
)