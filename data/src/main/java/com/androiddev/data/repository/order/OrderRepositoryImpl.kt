package com.androiddev.data.repository.order

import com.androiddev.data.dtoToEntity.OrderShoppItemsMapper
import com.androiddev.domain.entity.response.ShoppingEntity
import com.androiddev.domain.repository.OrderRepository
import com.androiddev.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val shoppingRepository: ShoppingRepository,
    private val mapper: OrderShoppItemsMapper
) : OrderRepository {
    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 99
    }

    private val shopItems = mutableListOf<ShoppingEntity.OrderItems>()

    override suspend fun getOrderItems(): Flow<List<ShoppingEntity.OrderItems>> {
        return flow {
            if (shopItems.isEmpty()) {
                shopItems.addAll(
                    mapper.map(shoppingRepository.getAllItems())
                )
            }
            emit(shopItems)
        }
    }

    override suspend fun add(orderId: Long): Flow<Boolean> {
        return flow {
            val index = shopItems.indexOfFirst { it.id == orderId }
            val result = if (index > -1) {
                val shopItem = shopItems[index]
                val newValue =
                    if (shopItem.count == MAX_VALUE) MAX_VALUE else shopItem.count + 1
                shopItems[index] = shopItem.copy(count = newValue)
                true
            } else {
                false
            }
            emit(result)
        }
    }

    override suspend fun remove(orderId: Long): Flow<Boolean> {
        return flow {
            val index = shopItems.indexOfFirst { it.id == orderId }
            val result = if (index > -1) {
                val shopItem = shopItems[index]
                val newValue =
                    if (shopItem.count == MIN_VALUE) MIN_VALUE else shopItem.count - 1
                shopItems[index] = shopItem.copy(count = newValue)
                true
            } else {
                false
            }
            emit(result)
        }
    }
}
