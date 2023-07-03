package com.yumtaufikhidayat.made.model.main


import com.google.gson.annotations.SerializedName

data class MovieMainResponse(
    @SerializedName("dates")
    val dates: MovieMainDates = MovieMainDates(),
    @SerializedName("page")
    val page: Int = 0, // 1
    @SerializedName("results")
    val results: List<MovieMainResult> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int = 0, // 87
    @SerializedName("total_results")
    val totalResults: Int = 0 // 1734
)