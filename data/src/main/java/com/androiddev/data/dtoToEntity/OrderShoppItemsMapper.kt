package com.androiddev.data.dtoToEntity

import com.androiddev.domain.entity.response.ShoppingEntity


class OrderShoppItemsMapper {

    fun map(shoppingItem: ShoppingEntity.ShoppingItem, count: Int = 0): ShoppingEntity.OrderItems {
        return ShoppingEntity.OrderItems(
            id = shoppingItem.titleId,
            name = shoppingItem.subTitleId,
            imageUrl = shoppingItem.imageUrl,
            price = shoppingItem.price,
            count = count
        )
    }

    fun map(
        coffeeDrinks: List<ShoppingEntity.ShoppingItem>,
        count: Int = 0
    ): List<ShoppingEntity.OrderItems> {
        return coffeeDrinks.map { map(it, count) }
    }
}
