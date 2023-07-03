package com.yumtaufikhidayat.made.model.main


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieMainResult(
    @SerializedName("adult")
    val adult: Boolean = false, // false
    @SerializedName("backdrop_path")
    val backdropPath: String = "", // /iJQIbOPm81fPEGKt5BPuZmfnA54.jpg
    @SerializedName("genre_ids")
    val genreIds: List<Int> = listOf(),
    @SerializedName("id")
    val id: Int = 0, // 502356
    @SerializedName("original_language")
    val originalLanguage: String = "", // en
    @SerializedName("original_title")
    val originalTitle: String = "", // The Super Mario Bros. Movie
    @SerializedName("overview")
    val overview: String = "", // While working underground to fix a water main, Brooklyn plumbers—and brothers—Mario and Luigi are transported down a mysterious pipe and wander into a magical new world. But when the brothers are separated, Mario embarks on an epic quest to find Luigi.
    @SerializedName("popularity")
    val popularity: Double = 0.0, // 6572.614
    @SerializedName("poster_path")
    val posterPath: String = "", // /qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg
    @SerializedName("release_date")
    val releaseDate: String? = "", // 2023-04-05
    @SerializedName("title")
    val title: String = "", // The Super Mario Bros. Movie
    @SerializedName("video")
    val video: Boolean = false, // false
    @SerializedName("vote_average")
    val voteAverage: Double = 0.0, // 7.5
    @SerializedName("vote_count")
    val voteCount: Int = 0 // 1456
): Parcelable