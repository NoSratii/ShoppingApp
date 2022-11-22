package com.androiddev.movieapp.presentation.screen.home


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.androiddev.movieapp.ui.theme.AppContentColor
import com.androiddev.movieapp.ui.theme.AppThemeColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.AppThemeColor
    val allMovies by viewModel.movies.collectAsState()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }
    MovieListContent(allMovies = allMovies, navController = navController)

}

