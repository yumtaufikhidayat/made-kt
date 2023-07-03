package com.yumtaufikhidayat.made.model.reviews


import com.google.gson.annotations.SerializedName

data class AuthorDetails(
    @SerializedName("avatar_path")
    val avatarPath: String = "", // /blEC280vq31MVaDcsWBXuGOsYnB.jpg
    @SerializedName("name")
    val name: String = "",
    @SerializedName("rating")
    val rating: Double = 0.0, // 7.0
    @SerializedName("username")
    val username: String = "" // ObjectivityGate
)