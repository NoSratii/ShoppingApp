package com.androiddev.domain.entity.response

import androidx.annotation.DrawableRes

sealed class ShoppingEntity {

    data class ShopResponse(
        val isLoading: Boolean = false,
        val error: String? = null,
        val endReached: Boolean = false,
        val page: Int = 0,
        val items: List<ShoppingItem> = emptyList(),
    )

    data class ShoppingItem(
        val titleId: Long,
        val subTitleId: String,
        val imageUrl: String,
        val hasOff: Boolean = false,
        val price: Double = 0.0,
        val count: Int = -1,
        val description: String? = null
    )

    data class OrderItems(
        val id: Long,
        val name: String,
        val imageUrl: String,
        val price: Double,
        val count: Int
    )

}
