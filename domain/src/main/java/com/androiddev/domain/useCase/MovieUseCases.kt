package com.androiddev.domain.useCase

import com.androiddev.domain.entity.common.ResultState
import com.androiddev.domain.entity.response.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieUseCases{
    fun getPopularMoviesUseCase(): Flow<ResultState<MovieEntity.BatmanMovie>>
    //fun getMoviesFromDBUseCase(movieId: Int)
}

