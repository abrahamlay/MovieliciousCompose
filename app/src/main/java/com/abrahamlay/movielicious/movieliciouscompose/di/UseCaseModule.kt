package com.abrahamlay.movielicious.movieliciouscompose.di

import com.abrahamlay.movielicious.domain.AndroidUIThread
import com.abrahamlay.movielicious.domain.PostExecutionThread
import com.abrahamlay.movielicious.domain.interactors.GetPopularMovies
import com.abrahamlay.movielicious.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providePostExecutionThread(): PostExecutionThread = AndroidUIThread()

    @Provides
    @Singleton
    fun provideGetPopularMovies(
        movieRepository: MovieRepository,
        postExecutionThread: PostExecutionThread
    ): GetPopularMovies {
        return GetPopularMovies(movieRepository, postExecutionThread)
    }
}