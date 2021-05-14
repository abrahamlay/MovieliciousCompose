package com.abrahamlay.movielicious.movieliciouscompose.config

/**
 * Created by Abraham Lay on 09/06/20.
 */
class Constants {
    companion object {
        const val POPULAR: Int = 0
        const val TOP_RATED: Int = 1
        const val NOW_PLAYING: Int = 2
        const val FAVORITE: Int = 3
        const val API_KEY = "e1364e3bc8f9d46c4a09586973081f96"

        const val MOVIE_THUMBNAIL_BASE_URL_EXTRA_SMALL = "https://image.tmdb.org/t/p/w92/%s"
        const val MOVIE_THUMBNAIL_BASE_URL_SMALL = "https://image.tmdb.org/t/p/w154/%s"
        const val MOVIE_THUMBNAIL_BASE_URL_MEDIUM = "https://image.tmdb.org/t/p/w185/%s"
        const val MOVIE_THUMBNAIL_BASE_URL_LARGE = "https://image.tmdb.org/t/p/w342/%s"
        const val MOVIE_THUMBNAIL_BASE_URL_EXTRA_LARGE = "https://image.tmdb.org/t/p/w500/%s"
        const val MOVIE_THUMBNAIL_BASE_URL_DOUBLE_EXTRA_LARGE = "https://image.tmdb.org/t/p/w780/%s"
        const val PARAM_RESULT_ITEM = "ResultItem"
    }
}