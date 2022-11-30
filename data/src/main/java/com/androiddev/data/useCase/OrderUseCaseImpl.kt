package com.androiddev.data.useCase

import com.androiddev.data.repository.order.OrderRepositoryImpl
import com.androiddev.domain.entity.response.ShoppingEntity
import com.androiddev.domain.useCase.OrderUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderUseCaseImpl @Inject constructor(private val orderRepository: OrderRepositoryImpl) :
    OrderUseCase {
    override suspend fun getOrderItems(): Flow<List<ShoppingEntity.OrderItems>> {
        return orderRepository.getOrderItems()
    }

    override suspend fun add(orderId: Long): Flow<Boolean> {
        return orderRepository.add(orderId)
    }

    override suspend fun remove(orderId: Long): Flow<Boolean> {
        return orderRepository.remove(orderId)
    }
}