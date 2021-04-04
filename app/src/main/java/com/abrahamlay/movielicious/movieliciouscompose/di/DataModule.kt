package com.abrahamlay.movielicious.movieliciouscompose.di

import android.content.Context
import androidx.room.Room
import com.abrahamlay.data.db.AppDatabase
import com.abrahamlay.movielicious.data.db.MovieDao
import com.abrahamlay.movielicious.data.mapper.DetailMovieMapper
import com.abrahamlay.movielicious.data.mapper.MovieMapper
import com.abrahamlay.movielicious.data.mapper.ReviewMapper
import com.abrahamlay.movielicious.data.mapper.VideoMapper
import com.abrahamlay.movielicious.data.remote.MovieApi
import com.abrahamlay.movielicious.data.repositoriesimpl.MovieRepositoryImpl
import com.abrahamlay.movielicious.domain.repositories.MovieRepository
import com.abrahamlay.movielicious.movieliciouscompose.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieApi: MovieApi, movieDao: MovieDao): MovieRepository =
        MovieRepositoryImpl(
            movieApi, movieDao, MovieMapper(), ReviewMapper(),
            VideoMapper(), DetailMovieMapper()
        )

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.APPLICATION_ID)
            .build()

    @Singleton
    @Provides
    fun provideMovieDao(appDatabase: AppDatabase) = appDatabase.movieDao()
}