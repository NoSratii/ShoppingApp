package com.androiddev.shoppingapp.di

import com.androiddev.data.errorHandler.ErrorHandler
import com.androiddev.data.errorHandler.ErrorHandlerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilsModule {

    @Binds
    abstract fun bindErrorHandler(errorHandlerImpl: ErrorHandlerImpl): ErrorHandler

}
