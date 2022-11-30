package com.androiddev.shoppingapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.androiddev.shoppingapp.presentation.screen.details.DetailsScreen
import com.androiddev.shoppingapp.presentation.screen.home.HomeScreen
import com.androiddev.shoppingapp.util.Constant.SHOPPING_DETAILS_ARGUMENT_KEY

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.DetailsScreen.route,
            arguments = listOf(navArgument(SHOPPING_DETAILS_ARGUMENT_KEY) {
                type = NavType.LongType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(SHOPPING_DETAILS_ARGUMENT_KEY)
            DetailsScreen(navController = navController)
        }

    }
}