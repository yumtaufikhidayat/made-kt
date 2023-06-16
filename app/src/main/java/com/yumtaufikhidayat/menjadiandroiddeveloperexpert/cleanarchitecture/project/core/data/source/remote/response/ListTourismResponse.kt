package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTourismResponse(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("places")
    val places: List<TourismResponse>
)