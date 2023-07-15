package com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    @SerializedName("name")
    val name: String = "", // Citadel of Ricks
    @SerializedName("url")
    val url: String = "" // https://rickandmortyapi.com/api/location/3
): Parcelable