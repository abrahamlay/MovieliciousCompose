package com.abrahamlay.movielicious.data.mapper

import com.abrahamlay.data.dtos.DetailMovieDto
import com.abrahamlay.movielicious.domain.entities.DetailMovieModel

/**
 * Created by Abraham Lay on 14/06/20.
 */

class DetailMovieMapper : Mapper<DetailMovieDto?, DetailMovieModel>() {
    override fun apply(from: DetailMovieDto?): DetailMovieModel? {
        return DetailMovieModel(
            from?.adult,
            from?.backdropPath,
            from?.belongsToCollection,
            from?.budget,
            from?.genres?.map { genre -> DetailMovieModel.Genre(genre?.id, genre?.name) },
            from?.homepage,
            from?.id,
            from?.imdbId,
            from?.originalLanguage,
            from?.originalTitle,
            from?.overview,
            from?.popularity,
            from?.posterPath,
            from?.productionCompanies?.map { company ->
                DetailMovieModel.ProductionCompany(
                    company?.id,
                    company?.logoPath,
                    company?.name,
                    company?.originCountry
                )
            },
            from?.productionCountries?.map { country ->
                DetailMovieModel.ProductionCountry(
                    country?.iso31661,
                    country?.name
                )
            },
            from?.releaseDate,
            from?.revenue,
            from?.runtime,
            from?.spokenLanguages?.map { language ->
                DetailMovieModel.SpokenLanguage(
                    language?.iso6391,
                    language?.name
                )
            },
            from?.status,
            from?.tagline,
            from?.title,
            from?.video,
            from?.voteAverage,
            from?.voteCount
        )
    }
}
