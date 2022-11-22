package com.androiddev.movieapp.presentation.screen.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable

/*

@Composable
fun MovieDetailsContent(movie: Movie) {
    val scrollState = rememberScrollState()
*/
/*    Card(
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.AppThemeColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = Constant.POSTER_URL + movie.posterPath, builder = {
                        crossfade(true)
                        scale(Scale.FIT)
                    }),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                movie.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                movie.releaseDate?.let {
                    ReleaseDateComponent(releaseDate = it)
                }
                Spacer(modifier = Modifier.height(8.dp))
                movie.rating?.let { RatingComponent(rating = it) }
                Spacer(modifier = Modifier.height(16.dp))
                movie.overview?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }*//*

}*/
