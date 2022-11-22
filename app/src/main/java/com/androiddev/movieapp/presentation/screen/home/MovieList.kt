package com.androiddev.movieapp.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.androiddev.domain.entity.response.MovieEntity
import com.androiddev.movieapp.presentation.component.RatingComponent
import com.androiddev.movieapp.ui.theme.ItemBackgroundColor


@Composable
fun MovieListContent(allMovies: List<MovieEntity.Search>?, navController: NavHostController) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        allMovies?.size?.let {
            items(it) { index ->
                if (allMovies.isNotEmpty()) {
                    MovieListItem(movie = allMovies[index], navController = navController)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

}

@Composable
fun MovieListItem(movie: MovieEntity.Search, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .height(180.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.ItemBackgroundColor
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth()
                .clickable {
                    // navController.navigate(route = Screen.MovieDetails.passMovieId(movie.movieId.toString()))
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(
                        end = 4.dp,
                    )
                    .width(120.dp),
                painter = rememberImagePainter(
                    data =  movie.poster, builder = {
                        crossfade(true)
                        scale(Scale.FILL)
                    }),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier
                    .height(IntrinsicSize.Max)
                    .padding(
                        end = 2.dp,
                    )) {
                movie.title?.let { Text(text = it, style = MaterialTheme.typography.body1) }
                Spacer(modifier = Modifier.height(4.dp))
                movie.imdbID?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                movie.imdbID?.let { RatingComponent(rating = it) }
            }
        }
    }
}
