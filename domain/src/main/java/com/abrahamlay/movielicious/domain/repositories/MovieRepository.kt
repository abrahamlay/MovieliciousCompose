package com.abrahamlay.movielicious.domain.repositories

import com.abrahamlay.movielicious.domain.entities.DetailMovieModel
import com.abrahamlay.movielicious.domain.entities.MovieModel
import com.abrahamlay.movielicious.domain.entities.ReviewModel
import com.abrahamlay.movielicious.domain.entities.VideoModel
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 2019-09-29.
 */

interface MovieRepository {
    fun getPopularMovies(apiKey: String): Flowable<List<MovieModel>?>
    fun getTopRatedMovies(apiKey: String): Flowable<List<MovieModel>?>
    fun getNowPlayingMovies(apiKey: String): Flowable<List<MovieModel>?>
//    fun getFavoriteMovies(): Flowable<List<MovieModel>?>
//    fun getFavoriteMovie(movieId: Int): Flowable<MovieModel?>
//    fun insertFavoriteMovie(movieModel: MovieModel): Long
//    fun deleteFavoriteMovie(movieModel: MovieModel): Int
    fun getReviews(
        apiKey: String,
        movieId: Int
    ): Flowable<List<ReviewModel>>

    fun getVideo(
        apiKey: String,
        movieId: Int
    ): Flowable<List<VideoModel>>

    fun getMovieDetails(
        apiKey: String,
        movieId: Int
    ): Flowable<DetailMovieModel>


}