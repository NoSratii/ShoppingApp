package com.androiddev.domain.repository

import com.androiddev.domain.entity.common.ResultState
import com.androiddev.domain.entity.response.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<ResultState<MovieEntity.BatmanMovie>>
   // fun getMoviesFromDB(movieId: Int): Flow<Movie>
}