package com.androiddev.domain.repository

import com.androiddev.domain.entity.response.ShoppingEntity
import kotlinx.coroutines.flow.Flow

interface OrderRepository {

    suspend fun getOrderItems(): Flow<List<ShoppingEntity.OrderItems>>

    suspend fun add(coffeeDrinkId: Long): Flow<Boolean>

    suspend fun remove(coffeeDrinkId: Long): Flow<Boolean>
}