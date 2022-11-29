package com.androiddev.data.remote

import com.androiddev.data.dto.MovieDto
import com.androiddev.domain.entity.response.ShoppingEntity

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("?apikey=3e974fca&s=batman")
    suspend fun getAllMovies(): Response<MovieDto.BatmanMovie>


    @GET("?apikey=3e974fca&i={imdbID}")
    suspend fun getMovieDetails(@Query("imdbID") imdbId: String): Response<MovieDto.Search>

}