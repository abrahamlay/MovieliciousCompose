package com.abrahamlay.movielicious.domain.interactors

import com.abrahamlay.movielicious.domain.FlowableUseCase
import com.abrahamlay.movielicious.domain.PostExecutionThread
import com.abrahamlay.movielicious.domain.entities.MovieModel
import com.abrahamlay.movielicious.domain.repositories.MovieRepository
import io.reactivex.Flowable


/**
 * Created by Abraham Lay on 2019-09-29.
 */
class GetNowPlayingMovies constructor(
    private val repository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : FlowableUseCase<List<MovieModel>?, GetNowPlayingMovies.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<List<MovieModel>?> =
        repository.getNowPlayingMovies(params.apiKey)

    data class Params(val apiKey: String)
}