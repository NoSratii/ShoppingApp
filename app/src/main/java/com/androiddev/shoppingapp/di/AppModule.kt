package com.androiddev.shoppingapp.di

import com.androiddev.data.dtoToEntity.OrderShoppItemsMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOrderMapper(): OrderShoppItemsMapper {
        return OrderShoppItemsMapper()
    }
}