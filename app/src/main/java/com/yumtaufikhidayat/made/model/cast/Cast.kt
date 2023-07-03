package com.yumtaufikhidayat.made.model.cast


import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("adult")
    val adult: Boolean = false, // false
    @SerializedName("cast_id")
    val castId: Int = 0, // 3
    @SerializedName("character")
    val character: String = "", // Becky Connor
    @SerializedName("credit_id")
    val creditId: String = "", // 62a21d28e22d2800a884c888
    @SerializedName("gender")
    val gender: Int = 0, // 1
    @SerializedName("id")
    val id: Int = 0, // 54633
    @SerializedName("known_for_department")
    val knownForDepartment: String = "", // Acting
    @SerializedName("name")
    val name: String = "", // Grace Caroline Currey
    @SerializedName("order")
    val order: Int = 0, // 0
    @SerializedName("original_name")
    val originalName: String = "", // Grace Caroline Currey
    @SerializedName("popularity")
    val popularity: Double = 0.0, // 33.42
    @SerializedName("profile_path")
    val profilePath: String = "" // /6chZcnjWEiFfpmB6D5BR9YUeIs9.jpg
)