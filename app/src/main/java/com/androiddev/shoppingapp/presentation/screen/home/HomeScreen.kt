package com.androiddev.shoppingapp.presentation.screen.home


import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.androiddev.shoppingapp.R
import com.androiddev.shoppingapp.presentation.component.OrderSummary
import com.androiddev.shoppingapp.presentation.component.alertdialog.AlertDialogComponent
import com.androiddev.shoppingapp.presentation.component.shimmer.LoadingShimmerEffect
import java.math.BigDecimal

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val activity = (LocalContext.current as? Activity)
    val state = viewModel.state
    val orderState = viewModel.orderState

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
            modifier = Modifier.padding(8.dp)
        ) {
            repeat(10) {
                item { LoadingShimmerEffect() }
            }
        }

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (orderState.totalPrice > BigDecimal(0.0)) {

            OrderSummary(orderState = orderState)
        }
        ShopListContent(
            orderState = orderState,
            navController = navController,
            onRemoved = { viewModel.removeShoppingItem(it) },
            onAdded = { viewModel.addShoppingItem(it) },
        )
    }


}

