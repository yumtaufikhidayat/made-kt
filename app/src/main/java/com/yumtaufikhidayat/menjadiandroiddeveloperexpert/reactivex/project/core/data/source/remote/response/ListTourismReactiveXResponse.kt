package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTourismReactiveXResponse(
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("places")
    val places: List<TourismReactiveXResponse>
)