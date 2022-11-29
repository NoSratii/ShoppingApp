package com.androiddev.shoppingapp.di

import com.androiddev.data.useCase.ShoppingUseCaseImpl
import com.androiddev.domain.useCase.ShoppingUseCases
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindShopUseCase(
        shoppingUseCaseImpl: ShoppingUseCaseImpl
    ): ShoppingUseCases

}