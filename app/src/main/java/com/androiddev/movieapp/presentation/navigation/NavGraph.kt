package com.androiddev.movieapp.presentation.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.androiddev.movieapp.util.Constant.MOVIE_GRAPH_ROUTE

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MOVIE_GRAPH_ROUTE
    ) {
        movieNavGraph(navController = navController)
    }
}