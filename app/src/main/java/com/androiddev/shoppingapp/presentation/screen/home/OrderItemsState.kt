package com.androiddev.shoppingapp.presentation.screen.home

import com.androiddev.domain.entity.response.ShoppingEntity
import java.math.BigDecimal

data class OrderItemsState(
    val orderItems: List<ShoppingEntity.OrderItems> = emptyList(),
    val totalPrice: BigDecimal = BigDecimal(0.0)
)
