package com.androiddev.shoppingapp.presentation.screen.details

import com.androiddev.domain.entity.response.ShoppingEntity

data class DetailsState(
    val isLoading: Boolean = false,
    val orderItems: List<ShoppingEntity.OrderItems> = emptyList(),
    val error: String? = null,

    )
