package com.abrahamlay.movielicious.data.remote

import com.abrahamlay.movielicious.data.dtos.*
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieApi {
    @GET("3/discover/movie")
    fun getDiscoverMoviesByGenre(
        @Query("api_key") apiKey: String,
        @QueryMap map: HashMap<String, Any>
    ): Flowable<MovieDto>

    @GET("3/genre/movie/list")
    fun getGenres(@Query("api_key") apiKey: String): Flowable<GenresDto>

    @GET("3/movie/{movieId}/reviews")
    fun getReviews(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String
    ): Flowable<ReviewDto>

    @GET("3/movie/{movieId}/videos")
    fun getVideo(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String
    ): Flowable<VideoDto>

    @GET("3/movie/{movieId}")
    fun getMovieDetails(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String
    ): Flowable<DetailMovieDto>

    @GET("3/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Flowable<MovieDto>

    @GET("3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Flowable<MovieDto>

    @GET("3/movie/now_playing")
    fun getNowPlayingMovies(@Query("api_key") apiKey: String): Flowable<MovieDto>
}