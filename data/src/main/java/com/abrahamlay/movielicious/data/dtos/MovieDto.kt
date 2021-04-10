package com.abrahamlay.movielicious.data.dtos

import com.google.gson.annotations.SerializedName

/**
 * Created by Abraham Lay on 2020-06-09.
 */

data class MovieDto(
    @SerializedName("page")
    var page: Int = 0,

    @SerializedName("total_results")
    val totalResults: Int = 0,

    @SerializedName("total_pages")
    var totalPages: Int = 0,

    @SerializedName("results")
    var results: List<Movie>
) {

    class Movie(
        @SerializedName("vote_count")
        var voteCount: Int = 0,

        @SerializedName("id")
        var id: Int = 0,

        @SerializedName("video")
        var video: Boolean = false,

        @SerializedName("vote_average")
        var voteAverage: Double = 0.0,

        @SerializedName("title")
        var title: String? = null,

        @SerializedName("popularity")
        var popularity: Double = 0.0,

        @SerializedName("poster_path")
        var posterPath: String? = null,

        @SerializedName("original_language")
        var originalLanguage: String? = null,

        @SerializedName("original_title")
        var originalTitle: String? = null,

        @SerializedName("genre_ids")
        var genreIds: List<Int>,

        @SerializedName("backdrop_path")
        var backdropPath: String? = null,

        @SerializedName("adult")
        var adult: Boolean = false,

        @SerializedName("overview")
        var overview: String? = null,

        @SerializedName("release_date")
        var releaseDate: String? = null
    )
}