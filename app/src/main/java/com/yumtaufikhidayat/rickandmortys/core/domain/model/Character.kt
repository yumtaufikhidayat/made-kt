package com.yumtaufikhidayat.rickandmortys.core.domain.model

import android.os.Parcelable
import com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response.Location
import com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response.Origin
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    val isFavorite: Boolean
): Parcelable