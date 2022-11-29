package com.androiddev.shoppingapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.androiddev.shoppingapp.presentation.screen.home.HomeScreen
import com.androiddev.shoppingapp.util.Constant

fun NavGraphBuilder.movieNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.HomeScreen.route, route = Screen.HomeScreen.route) {

        composable(route = Screen.HomeScreen.route) {
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
        }
        }
    }

