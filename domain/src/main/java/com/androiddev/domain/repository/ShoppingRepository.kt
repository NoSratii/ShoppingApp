package com.androiddev.domain.repository

import com.androiddev.domain.entity.response.ShoppingEntity

interface ShoppingRepository {

    suspend fun getPopularItemsRepository(
        page: Int,
        pageSize: Int
    ): Result<List<ShoppingEntity.ShoppingItem>>

}