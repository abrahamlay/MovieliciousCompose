package com.abrahamlay.movielicious.movieliciouscompose.di

import com.abrahamlay.movielicious.data.remote.MovieApi
import com.abrahamlay.movielicious.movieliciouscompose.config.WebApiProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideWebApiProvider(): WebApiProvider = WebApiProvider

    @Singleton
    @Provides
    fun provideRetrofit(webApiProvider: WebApiProvider): Retrofit = webApiProvider.getRetrofit()

    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(
        MovieApi::class.java
    )
}