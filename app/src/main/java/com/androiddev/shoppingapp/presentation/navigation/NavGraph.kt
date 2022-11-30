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
import com.androiddev.domain.entity.response.ShoppingEntity
import com.androiddev.shoppingapp.presentation.screen.SplashScreen
import com.androiddev.shoppingapp.presentation.screen.details.DetailsScreen
import com.androiddev.shoppingapp.presentation.screen.home.HomeScreen
import com.androiddev.shoppingapp.util.Constant
import com.androiddev.shoppingapp.util.Constant.SHOPPING_DETAILS_ARGUMENT_KEY

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