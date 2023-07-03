package com.yumtaufikhidayat.made.model.cast


import com.google.gson.annotations.SerializedName

data class Crew(
    @SerializedName("adult")
    val adult: Boolean = false, // false
    @SerializedName("credit_id")
    val creditId: String = "", // 63ee7eeb88b148008ff891ec
    @SerializedName("department")
    val department: String = "", // Production
    @SerializedName("gender")
    val gender: Int = 0, // 2
    @SerializedName("id")
    val id: Int = 0, // 65814
    @SerializedName("job")
    val job: String = "", // Executive Producer
    @SerializedName("known_for_department")
    val knownForDepartment: String = "", // Production
    @SerializedName("name")
    val name: String = "", // Barry Brooker
    @SerializedName("original_name")
    val originalName: String = "", // Barry Brooker
    @SerializedName("popularity")
    val popularity: Double = 0.0, // 1.572
    @SerializedName("profile_path")
    val profilePath: String = "" // /8WygpUzfdfztZQqxGE5zn3rCedJ.jpg
)