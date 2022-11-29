package com.androiddev.domain.useCase

import com.androiddev.domain.entity.response.ShoppingEntity

interface ShoppingUseCases {
    suspend fun getPopularItemsUseCase(
        page: Int,
        pageSize: Int
    ): Result<List<ShoppingEntity.ShoppingItem>>
}

