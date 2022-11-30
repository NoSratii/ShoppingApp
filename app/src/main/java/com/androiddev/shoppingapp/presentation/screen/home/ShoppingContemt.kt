package com.androiddev.shoppingapp.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.androiddev.shoppingapp.presentation.component.ShoppingItem
import com.androiddev.shoppingapp.presentation.navigation.Screen


@Composable
fun ShopListContent(
    orderState: OrderItemsState,
    navController: NavHostController,
    onAdded: (orderId: Long) -> Unit,
    onRemoved: (orderId: Long) -> Unit,
) {

    LazyVerticalGrid(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(all = 8.dp),
        content = {
            items(orderState.orderItems.size) { index ->

                ShoppingItem(
                    orderItem = orderState.orderItems[index],
                    onAdded = { onAdded(it) },
                    onRemoved = { onRemoved(it) },
                    onItemClick = {
                        navController.navigate(Screen.DetailsScreen.passShopItem(orderState.orderItems[index].id))
                    })
            }
        }
    )

}
