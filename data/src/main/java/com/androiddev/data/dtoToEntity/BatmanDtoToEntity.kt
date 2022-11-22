package com.androiddev.data.dtoToEntity

import com.androiddev.data.dto.MovieDto
import com.androiddev.domain.entity.common.ResultState
import com.androiddev.domain.entity.response.MovieEntity

@JvmName("batmanDtoToEntity")
fun ResultState<MovieDto.BatmanMovie>.map(): ResultState<MovieEntity.BatmanMovie> {
    return when (this) {
        is ResultState.Success -> ResultState.Success(
            data = data.let { item ->
                MovieEntity.BatmanMovie(
                    search = item?.search?.map { movie ->
                        MovieEntity.Search(
                            title = movie.title,
                            year = movie.year,
                            imdbID = movie.imdbID,
                            type = movie.type,
                            poster = movie.poster
                        )

                    },
                    totalResults = item?.totalResults.toString(),
                    response = item?.response.toString(),
                )
            },
            responseCode = responseCode
        )
        is ResultState.Error -> ResultState.Error(error = error)
    }
}