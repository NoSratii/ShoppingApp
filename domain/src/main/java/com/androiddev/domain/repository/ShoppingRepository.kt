package com.androiddev.domain.repository

import com.androiddev.domain.entity.response.ShoppingEntity
import kotlinx.coroutines.flow.Flow

interface ShoppingRepository {

    suspend fun getPopularItemsRepository(
        page: Int,
        pageSize: Int
    ): Result<List<ShoppingEntity.ShoppingItem>>

    fun getAllItems(): List<ShoppingEntity.ShoppingItem>

}