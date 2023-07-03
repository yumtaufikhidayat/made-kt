package com.yumtaufikhidayat.made.model.detail


import com.google.gson.annotations.SerializedName

data class BelongsToCollection(
    @SerializedName("backdrop_path")
    val backdropPath: String = "", // /jIiG74G4HZJhuuqX6JM45VlWb5D.jpg
    @SerializedName("id")
    val id: Int = 0, // 663623
    @SerializedName("name")
    val name: String = "", // Ay Lav Yu [Seri]
    @SerializedName("poster_path")
    val posterPath: String = "" // /2BP1XCONVZ78xaXrYGZa9nPJxKo.jpg
)