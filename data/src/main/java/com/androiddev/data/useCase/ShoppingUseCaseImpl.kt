package com.androiddev.data.useCase

import com.androiddev.data.repository.ShoppingRepositoryImpl
import com.androiddev.domain.entity.common.ResultState
import com.androiddev.domain.entity.response.ShoppingEntity
import com.androiddev.domain.useCase.ShoppingUseCases
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ShoppingUseCaseImpl @Inject constructor(private val repository: ShoppingRepositoryImpl) :
    ShoppingUseCases {


    override suspend fun getPopularItemsUseCase(
        page: Int,
        pageSize: Int
    ): Result<List<ShoppingEntity.ShoppingItem>> {

        return repository.getPopularItemsRepository(page = page, pageSize = pageSize)

    }

}