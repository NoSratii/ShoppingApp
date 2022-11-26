package com.androiddev.movieapp.di

import com.androiddev.data.useCase.MovieUseCaseImpl
import com.androiddev.domain.useCase.MovieUseCases
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindMovieUseCase(
        movieUseCaseImpl: MovieUseCaseImpl
    ): MovieUseCases

}