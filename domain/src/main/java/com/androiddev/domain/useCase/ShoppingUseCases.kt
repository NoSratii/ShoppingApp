package com.androiddev.domain.useCase

import com.androiddev.domain.entity.response.ShoppingEntity
import kotlinx.coroutines.flow.Flow

interface ShoppingUseCases {

    suspend fun getPopularItemsUseCase(
        page: Int,
        pageSize: Int
    ): Result<List<ShoppingEntity.ShoppingItem>>

    suspend fun getShoppingItems(): List<ShoppingEntity.ShoppingItem>
}

