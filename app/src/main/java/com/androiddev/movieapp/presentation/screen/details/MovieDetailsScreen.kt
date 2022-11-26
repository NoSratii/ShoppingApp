package com.androiddev.movieapp.presentation.screen.details

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.androiddev.movieapp.ui.theme.AppContentColor
import com.androiddev.movieapp.ui.theme.AppThemeColor


@Composable
fun MovieDetailsScreen(
    movieId: String,
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel(),
) {
   // viewModel.getMovieDetails(movieID = movieId.toInt())

}

