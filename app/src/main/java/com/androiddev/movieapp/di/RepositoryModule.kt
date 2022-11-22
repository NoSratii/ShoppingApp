package com.androiddev.movieapp.di

import com.androiddev.data.repository.BaseRepositoryImpl
import com.androiddev.data.repository.MovieRepositoryImpl
import com.androiddev.domain.repository.BaseRepository
import com.androiddev.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindBaseRepository(baseRepositoryImpl: BaseRepositoryImpl): BaseRepository

    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository

}