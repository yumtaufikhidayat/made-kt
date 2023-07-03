package com.yumtaufikhidayat.made.model.main


import com.google.gson.annotations.SerializedName

data class MovieMainDates(
    @SerializedName("maximum")
    val maximum: String = "", // 2023-05-03
    @SerializedName("minimum")
    val minimum: String = "" // 2023-03-16
)