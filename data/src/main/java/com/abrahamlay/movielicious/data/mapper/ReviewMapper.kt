package com.abrahamlay.movielicious.data.mapper

import com.abrahamlay.movielicious.data.dtos.ReviewDto
import com.abrahamlay.movielicious.domain.entities.ReviewModel


/**
 * Created by Abraham Lay on 14/06/20.
 */

class ReviewMapper : Mapper<ReviewDto?, List<ReviewModel>?>() {
    override fun apply(from: ReviewDto?): List<ReviewModel>? {
        return from?.results?.map { resultReview ->
            ReviewModel(
                resultReview.author,
                resultReview.content,
                resultReview.id,
                resultReview.url
            )
        }
    }
}