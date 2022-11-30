package com.androiddev.shoppingapp.presentation.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object DetailsScreen : Screen("details_screen/{itemId}") {
        fun passShopItem(itemId: Long) = "details_screen/$itemId"
    }

}
