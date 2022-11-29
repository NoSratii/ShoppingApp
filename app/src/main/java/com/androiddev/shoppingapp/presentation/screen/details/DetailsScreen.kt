package com.androiddev.shoppingapp.presentation.screen.details

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun DetailsScreen(
    navController: NavHostController,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    DetailsContent(navController = navController)

}





