package com.androiddev.domain.entity.response

sealed class ShoppingEntity {

    data class ShopResponse(
        val isLoading: Boolean = false,
        val error: String? = null,
        val endReached: Boolean = false,
        val page: Int = 0,
        val items: List<ShoppingItem> = emptyList(),
    )

    data class ShoppingItem(
        val titleId: String? = null,
        val subTitleId: String? = null,
        val icon: String? = null,
        val hasOff: Boolean = false,
        val price: Double = 0.0,
        val desc: String? = null
    )

}
