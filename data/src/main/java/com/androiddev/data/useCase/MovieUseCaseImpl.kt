package com.androiddev.data.useCase

import com.androiddev.domain.entity.common.ResultState
import com.androiddev.domain.entity.response.MovieEntity
import com.androiddev.domain.repository.MovieRepository
import com.androiddev.domain.useCase.MovieUseCases
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(private val repository: MovieRepository): MovieUseCases {


    override fun getPopularMoviesUseCase(): Flow<ResultState<MovieEntity.BatmanMovie>> {
        return repository.getPopularMovies()

    }
/*    override fun getMoviesFromDBUseCase(movieId: Int) {
        repository.getMoviesFromDB(movieId = movieId)
    }*/
}