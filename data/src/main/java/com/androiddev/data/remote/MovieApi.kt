package com.androiddev.data.remote

import com.androiddev.data.dto.MovieDto

import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {

    @GET("?apikey=3e974fca&s=batman")
    suspend fun getAllMovies(): Response<MovieDto.BatmanMovie>

}