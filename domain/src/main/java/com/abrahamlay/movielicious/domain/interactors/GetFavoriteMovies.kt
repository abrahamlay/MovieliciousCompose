package com.abrahamlay.movielicious.domain.interactors

import com.abrahamlay.movielicious.domain.FlowableUseCase
import com.abrahamlay.movielicious.domain.PostExecutionThread
import com.abrahamlay.movielicious.domain.entities.MovieModel
import com.abrahamlay.movielicious.domain.repositories.MovieRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 13/06/20.
 */
class GetFavoriteMovies constructor(
    private val repository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : FlowableUseCase<List<MovieModel>?, Void?>(postExecutionThread) {
    override fun build(params: Void?): Flowable<List<MovieModel>?> {
        return repository.getFavoriteMovies()
    }
}