package com.yumtaufikhidayat.made.model.reviews


import com.google.gson.annotations.SerializedName

data class MovieReviewResponse(
    @SerializedName("id")
    val id: Int = 0, // 985939
    @SerializedName("page")
    val page: Int = 0, // 1
    @SerializedName("results")
    val results: List<ReviewsResult> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int = 0, // 1
    @SerializedName("total_results")
    val totalResults: Int = 0 // 9
)