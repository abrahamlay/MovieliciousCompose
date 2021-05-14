package com.abrahamlay.movielicious.movieliciouscompose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.abrahamlay.movielicious.domain.entities.MovieModel
import com.abrahamlay.movielicious.domain.interactors.GetPopularMovies
import com.abrahamlay.movielicious.domain.subscriber.DefaultSubscriber
import com.abrahamlay.movielicious.domain.subscriber.ResultState
import com.abrahamlay.movielicious.movieliciouscompose.config.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPopularMovies: GetPopularMovies
) : ViewModel() {
    val movies: MutableState<ResultState<List<MovieModel>?>> =
        mutableStateOf(
            ResultState.Loading(
                arrayListOf()
            )
        )

    fun fetchMovie() {
        getPopularMovies.execute(
            object : DefaultSubscriber<List<MovieModel>?>() {
                override fun onError(error: ResultState<List<MovieModel>?>) {
                    movies.value = error
                }

                override fun onSuccess(data: ResultState<List<MovieModel>?>) {
                    movies.value = data
                }
            }, GetPopularMovies.Params(Constants.API_KEY)
        )
    }

    override fun onCleared() {
        super.onCleared()
        getPopularMovies.dispose()
    }
}