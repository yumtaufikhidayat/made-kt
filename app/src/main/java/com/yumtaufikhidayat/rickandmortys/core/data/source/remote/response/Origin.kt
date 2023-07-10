package com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Origin(
    @SerializedName("name")
    val name: String = "", // Earth (C-137)
    @SerializedName("url")
    val url: String = "" // https://rickandmortyapi.com/api/location/1
): Parcelable