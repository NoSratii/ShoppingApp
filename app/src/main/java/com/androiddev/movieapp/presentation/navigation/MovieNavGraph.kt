package com.androiddev.movieapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.androiddev.movieapp.presentation.screen.details.MovieDetailsScreen
import com.androiddev.movieapp.presentation.screen.home.HomeScreen
import com.androiddev.movieapp.util.Constant

fun NavGraphBuilder.movieNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Home.route, route = Screen.Home.route) {

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.MovieDetails.route,
            arguments = listOf(navArgument(Constant.MOVIE_DETAILS_ARGUMENT_KEY) {
                type = NavType.StringType
                nullable = true
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(Constant.MOVIE_DETAILS_ARGUMENT_KEY)
                ?.let { MovieDetailsScreen(it, navController) }
        }
    }

}