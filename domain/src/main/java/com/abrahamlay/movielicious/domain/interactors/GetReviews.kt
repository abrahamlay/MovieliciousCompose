package com.abrahamlay.movielicious.domain.interactors

import com.abrahamlay.movielicious.domain.FlowableUseCase
import com.abrahamlay.movielicious.domain.PostExecutionThread
import com.abrahamlay.movielicious.domain.entities.ReviewModel
import com.abrahamlay.movielicious.domain.repositories.MovieRepository
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 10/06/20.
 */
class GetReviews constructor(
    private val repository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : FlowableUseCase<List<ReviewModel>, GetReviews.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<List<ReviewModel>> {
        return repository.getReviews(params.apiKey, params.movieId)
    }

    data class Params(val apiKey: String, val movieId: Int)
}