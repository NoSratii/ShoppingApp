package com.androiddev.data.repository

import com.androiddev.domain.entity.response.ShoppingEntity
import com.androiddev.domain.repository.ShoppingRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShoppingRepositoryImpl @Inject constructor() : ShoppingRepository {


    private val remoteDataSource = (1..100).map {
        ShoppingEntity.ShoppingItem(
            titleId = it.toLong(),
            subTitleId = "اسباب بازی",
            imageUrl = "https://api.snapp.market/media/cache/product-variation_image_thumbnail/uploads/images/vendors/users/app/336724.jpg",
            hasOff = false,
            price = 17000.0,
            description = "اسباب بازی لودر سیبیلو آفرود ۲ رادا تویز",
        )
    }

    override suspend fun getPopularItemsRepository(
        page: Int,
        pageSize: Int
    ): Result<List<ShoppingEntity.ShoppingItem>> {
        delay(2000L)
        val startingIndex = page * pageSize
        return if (startingIndex + pageSize <= remoteDataSource.size) {
            Result.success(
                remoteDataSource.slice(startingIndex until startingIndex + pageSize)
            )
        } else Result.success(emptyList())

    }

    override fun getAllItems(): List<ShoppingEntity.ShoppingItem> {
        return remoteDataSource
    }


}