package com.androiddev.shoppingapp.di

import com.androiddev.data.repository.ShoppingRepositoryImpl
import com.androiddev.data.repository.order.OrderRepositoryImpl
import com.androiddev.domain.repository.OrderRepository
import com.androiddev.domain.repository.ShoppingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindShopRepository(
        shopRepositoryImpl: ShoppingRepositoryImpl
    ): ShoppingRepository


    @Binds
    abstract fun bindOrderRepository(
        orderRepositoryImpl: OrderRepositoryImpl
    ): OrderRepository

}