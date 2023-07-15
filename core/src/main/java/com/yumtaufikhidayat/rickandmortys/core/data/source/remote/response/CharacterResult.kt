package com.yumtaufikhidayat.rickandmortys.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class CharacterResult(
    @SerializedName("created")
    val created: String = "", // 2017-11-04T18:48:46.250Z
    @SerializedName("episode")
    val episode: List<String> = listOf(),
    @SerializedName("gender")
    val gender: String = "", // Male
    @SerializedName("id")
    val id: Int = 0, // 1
    @SerializedName("image")
    val image: String = "", // https://rickandmortyapi.com/api/character/avatar/1.jpeg
    @SerializedName("location")
    val location: Location = Location(),
    @SerializedName("name")
    val name: String = "", // Rick Sanchez
    @SerializedName("origin")
    val origin: Origin = Origin(),
    @SerializedName("species")
    val species: String = "", // Human
    @SerializedName("status")
    val status: String = "", // Alive
    @SerializedName("type")
    val type: String = "",
    @SerializedName("url")
    val url: String = "" // https://rickandmortyapi.com/api/character/1
)