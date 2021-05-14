package com.abrahamlay.movielicious.movieliciouscompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamlay.movielicious.domain.entities.MovieModel
import com.abrahamlay.movielicious.domain.subscriber.ResultState
import com.abrahamlay.movielicious.movieliciouscompose.ui.theme.MovieliciousComposeTheme
import com.abrahamlay.movielicious.movieliciouscompose.ui.utils.loadPicture
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieliciousComposeTheme {
                viewModel.fetchMovie()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                    ) {
                        HomeComponent(viewModel.movies)
                    }
                }
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Composable
    fun HomeComponent(array: MutableState<ResultState<List<MovieModel>?>>) {
        LazyColumn {
            items(count = 3) {
                when (array.value) {
                    is ResultState.Success -> {
                        LazyRow(modifier = Modifier.padding(8.dp)) {
                            val movies =
                                (array.value as ResultState.Success<List<MovieModel>?>).data
                                    ?: emptyList()
                            items(movies) { movie ->
                                ItemHorizontal(movie)
                            }
                        }
                    }
                    else -> {

                    }
                }
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Composable
    fun ItemHorizontal(movieModel: MovieModel?) {
        val image =
            loadPicture(url = movieModel?.posterPath, defaultImage = R.drawable.ic_profile)
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(
                            this,
                            "${movieModel?.title}",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                image.value?.let { bitmap ->
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Movie Backdrop",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.aspectRatio(
                            ratio = 0.75F,
                            matchHeightConstraintsFirst = true
                        ).heightIn(min = 200.dp, max = 280.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(
                    text = movieModel?.title ?: "Unknown Title",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(180.dp).wrapContentWidth(align = Alignment.CenterHorizontally)
                )
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        val array = arrayOf("Abraham", "Audrey", "Aurelio", "Angela", "Angelo")
        MovieliciousComposeTheme {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
//                HomeComponent(array = array)
            }
        }
    }
}