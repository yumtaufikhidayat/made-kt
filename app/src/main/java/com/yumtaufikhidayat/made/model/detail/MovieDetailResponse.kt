package com.yumtaufikhidayat.made.model.detail


import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("adult")
    val adult: Boolean = false, // false
    @SerializedName("backdrop_path")
    val backdropPath: String = "", // /aQAu4l3jZ6421JJDuu3FsXaS6PT.jpg
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollection = BelongsToCollection(),
    @SerializedName("budget")
    val budget: Int = 0, // 0
    @SerializedName("genres")
    val movieDetailGenres: List<MovieDetailGenre> = listOf(),
    @SerializedName("homepage")
    val homepage: String = "",
    @SerializedName("id")
    val id: Int = 0, // 49833
    @SerializedName("imdb_id")
    val imdbId: String = "", // tt1526284
    @SerializedName("original_language")
    val originalLanguage: String = "", // tr
    @SerializedName("original_title")
    val originalTitle: String = "", // Ay Lav Yu
    @SerializedName("overview")
    val overview: String = "",
    @SerializedName("popularity")
    val popularity: Double = 0.0, // 3.03
    @SerializedName("poster_path")
    val posterPath: String? = "", // /dXPzDhxXs4Z8Nnai7kgZ48iyN3U.jpg
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany> = listOf(),
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry> = listOf(),
    @SerializedName("release_date")
    val releaseDate: String = "", // 2010-03-12
    @SerializedName("revenue")
    val revenue: Int = 0, // 0
    @SerializedName("runtime")
    val runtime: Int = 0, // 102
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage> = listOf(),
    @SerializedName("status")
    val status: String = "", // Released
    @SerializedName("tagline")
    val tagline: String = "",
    @SerializedName("title")
    val title: String = "", // Ay Lav Yu
    @SerializedName("video")
    val video: Boolean = false, // false
    @SerializedName("vote_average")
    val voteAverage: Double = 0.0, // 5.269
    @SerializedName("vote_count")
    val voteCount: Int = 0 // 39
)