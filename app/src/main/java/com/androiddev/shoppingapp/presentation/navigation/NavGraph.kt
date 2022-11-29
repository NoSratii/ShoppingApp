package com.androiddev.shoppingapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.androiddev.shoppingapp.presentation.screen.SplashScreen
import com.androiddev.shoppingapp.presentation.screen.details.DetailsScreen
import com.androiddev.shoppingapp.presentation.screen.home.HomeScreen
import com.androiddev.shoppingapp.util.Constant

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    scaffoldState: ScaffoldState
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.DetailsScreen.route) {
            DetailsScreen(navController = navController)
        }
        composable(
            route = Screen.MovieDetails.route,
            arguments = listOf(navArgument(Constant.MOVIE_DETAILS_ARGUMENT_KEY) {
                type = NavType.StringType
                nullable = true
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(Constant.MOVIE_DETAILS_ARGUMENT_KEY)
            DetailsScreen(navController = navController)
        }
    }
}