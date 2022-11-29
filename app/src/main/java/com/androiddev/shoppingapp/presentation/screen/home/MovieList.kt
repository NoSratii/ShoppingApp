package com.androiddev.shoppingapp.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.androiddev.shoppingapp.presentation.component.ShoppingItem
import com.androiddev.shoppingapp.presentation.navigation.Screen


@Composable
fun ShopListContent(
    homeState: HomeState,
    navController: NavHostController,
    loadShopItems: () -> Unit
) {

    LazyVerticalGrid(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(all = 8.dp),
        content = {

            items(homeState.items.size) { index ->
                if (index >= homeState.items.size - 1 && !homeState.endReached && !homeState.isLoading) {
                    loadShopItems()
                }

                ShoppingItem(homeState.items[index]) {
                    navController.navigate(Screen.DetailsScreen.route)
                }
            }
            item {
                if (homeState.isLoading) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }


        }
    )

}
