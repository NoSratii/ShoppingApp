package com.androiddev.shoppingapp.presentation.navigation

import com.androiddev.domain.entity.response.ShoppingEntity

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object HomeScreen : Screen("home_screen")
    object DetailsScreen : Screen("details_screen/{itemId}") {
        fun passShopItem(itemId: Long) = "details_screen/$itemId"
    }

}
