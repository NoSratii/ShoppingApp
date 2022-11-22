package com.androiddev.movieapp.di

import android.app.Application
import coil.ImageLoader
import com.androiddev.data.errorHandler.ErrorHandler
import com.androiddev.data.errorHandler.ErrorHandlerImpl
import com.androiddev.data.repository.MovieRepositoryImpl
import com.androiddev.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilsModule {

    @Binds
    abstract fun bindErrorHandler(errorHandlerImpl: ErrorHandlerImpl): ErrorHandler


}
