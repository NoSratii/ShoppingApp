package com.androiddev.shoppingapp.presentation.screen.home


import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.androiddev.shoppingapp.R
import com.androiddev.shoppingapp.presentation.component.alertdialog.AlertDialogComponent
import com.androiddev.shoppingapp.presentation.component.shimmer.LoadingShimmerEffect

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val activity = (LocalContext.current as? Activity)
    val state = viewModel.state

    if (state.isShowDialog) {
        AlertDialogComponent(
            title = stringResource(id = R.string.warning), message = stringResource(
                id = R.string.please_try_another_time
            )
        ) {
            activity?.finish()
        }
    }

    if (state.isLoading) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(10.dp)
        ) {
            repeat(10) {
                item { LoadingShimmerEffect() }
            }
        }

    }

    ShopListContent(homeState = state, navController = navController) {
        viewModel.loadShopItems()
    }

}

