package com.androiddev.shoppingapp.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    state: ScaffoldState,
    onFabClick: () -> Unit = {},
    content: @Composable (Modifier) -> Unit
) {
    Scaffold(
        scaffoldState = state,
        isFloatingActionButtonDocked = true,
        modifier = modifier
    ) {
        content(Modifier.padding(it))
    }
}