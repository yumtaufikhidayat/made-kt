package com.yumtaufikhidayat.made.model.detail


import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("id")
    val id: Int = 0, // 19938
    @SerializedName("logo_path")
    val logoPath: Any = Any(), // null
    @SerializedName("name")
    val name: String = "", // Medyavizyon
    @SerializedName("origin_country")
    val originCountry: String = ""
)