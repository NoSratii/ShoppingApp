package com.androiddev.data.repository

import com.androiddev.data.remote.MovieApi
import com.androiddev.domain.entity.common.ResultState
import com.androiddev.domain.entity.response.MovieEntity
import com.androiddev.domain.repository.BaseRepository
import com.androiddev.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import com.androiddev.data.dtoToEntity.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val baseRepository: BaseRepository,
    private val movieApi: MovieApi,
    //   private val movieDB: MovieDB
) :
    MovieRepository {
    //private val movieDao = movieDB.movieDao()

/*
    override fun getMoviesFromDB(movieId: Int): Flow<Movie> =
        movieDao.getMovie(movieId)
*/

    override fun getPopularMovies(): Flow<ResultState<MovieEntity.BatmanMovie>> =
        flow<ResultState<MovieEntity.BatmanMovie>> {
            emit(baseRepository.callApi { movieApi.getAllMovies() }.map())
        }.flowOn(Dispatchers.IO)

}