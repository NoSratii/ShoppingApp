package com.androiddev.shoppingapp.presentation.screen.home

import com.androiddev.domain.entity.response.ShoppingEntity

data class HomeState(
    val isLoading: Boolean = false,
    val isShowDialog: Boolean = false,
    val items: List<ShoppingEntity.ShoppingItem> = emptyList(),
    val orderItems: List<ShoppingEntity.OrderItems> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)
