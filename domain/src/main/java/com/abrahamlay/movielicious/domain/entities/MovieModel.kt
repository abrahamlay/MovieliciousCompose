package com.abrahamlay.movielicious.domain.entities

import android.os.Parcelable
//import androidx.room.Entity
//import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Created by Abraham Lay on 2020-06-09.
 */
@Parcelize
//@Entity
data class MovieModel(
    var voteCount: Int,
//    @PrimaryKey
    var id: Int,
    var video: Boolean,
    var voteAverage: Double,
    var title: String?,
    var popularity: Double,
    var posterPath: String?,
    var originalLanguage: String?,
    var originalTitle: String?,
    var genreIds: List<Int>,
    var backdropPath: String?,
    var adult: Boolean,
    var overview: String?,
    var releaseDate: String?
) : Parcelable