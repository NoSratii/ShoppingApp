package com.androiddev.shoppingapp.presentation.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object HomeScreen : Screen("home_screen")
    object DetailsScreen : Screen("details_screen")
    object MovieDetails : Screen("details_screen/{movieId}") {
        fun passMovieId(movieId: String) = "movie_details_screen/$movieId"
    }
}
