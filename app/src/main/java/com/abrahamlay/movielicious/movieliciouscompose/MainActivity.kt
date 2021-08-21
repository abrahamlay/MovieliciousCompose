package com.abrahamlay.movielicious.movieliciouscompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aakarshrestha.composepagersnaphelper.ComposePagerSnapHelper
import com.abrahamlay.movielicious.domain.entities.MovieModel
import com.abrahamlay.movielicious.domain.subscriber.ResultState
import com.abrahamlay.movielicious.movieliciouscompose.ui.theme.MovieliciousComposeTheme
import com.abrahamlay.movielicious.movieliciouscompose.ui.utils.loadPicture
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.util.Collections.emptyList

@ExperimentalCoroutinesApi
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
                    HomeComponent()
                }
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Composable
    fun HomeComponent() {
        Column(
            modifier = Modifier
                .padding(start = 0.dp, top = 16.dp, end = 0.dp, bottom = 0.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            Toolbar()
            Spacer(modifier = Modifier.height(100.dp))
            LazyColumn {
                items(count = 1) {
                    Section()
                }
            }
        }
    }

    @Composable
    private fun Section() {
        when (viewModel.movies.value) {
            is ResultState.Success -> {
                ItemSection()
            }
            else -> Unit
        }
    }

    @Composable
    private fun ItemSection() {
        Column(Modifier.padding(start = 0.dp, top = 8.dp, end = 0.dp, bottom = 8.dp)
            ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Popular Movies",
                style = MaterialTheme.typography.h5
            )
            ComposePagerSnapHelper(width = 320.dp) {
                LazyRow(state = it) {
                    val movies =
                        (viewModel.movies.value as ResultState.Success<List<MovieModel>?>).data
                            ?: emptyList()
                    items(movies) { movie ->
                        ItemHorizontal(movie)
                    }
                }
            }
        }

    }

    @Composable
    fun Toolbar() {
        TopAppBar(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            title = { Text(text = stringResource(id = R.string.app_name)) },
            backgroundColor = MaterialTheme.colors.background,
            navigationIcon = {
                IconButton(
                    onClick = {
                        Toast.makeText(
                            this@MainActivity,
                            "Menu Clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = "Menu"
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = {
                        Toast.makeText(
                            this@MainActivity,
                            "Search Clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Menu Search"
                    )
                }
            },
            elevation = 0.dp
        )
    }

    @ExperimentalCoroutinesApi
    @Composable
    fun ItemHorizontal(movieModel: MovieModel?) {
        val image =
            loadPicture(
                url = movieModel?.posterPath,
                defaultImage = R.color.cardview_dark_background
            )
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier
                    .clickable {
                        Toast.makeText(
                            this@MainActivity, "${movieModel?.title}",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }) {

                image.value?.let { bitmap ->
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Movie Backdrop",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .aspectRatio(
                                ratio = 0.75F,
                                matchHeightConstraintsFirst = true
                            )
                            .heightIn(min = 280.dp, max = 360.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                text = movieModel?.title ?: "Unknown Title",
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .width(180.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
            )
            Row {
                Icon(
                    modifier = Modifier.padding(16.dp),
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "rating"
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                    text = "${movieModel?.voteAverage}"
                )
            }
        }

    }

    @Preview(showSystemUi = true)
    @Composable
    fun ArcList() {
        LazyRow(
            Modifier.height(200.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            items(20) {
                Column {
                    Text("Item $it", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}