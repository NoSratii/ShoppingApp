package com.androiddev.movieapp.presentation.screen.home

import com.androiddev.domain.entity.response.MovieEntity

data class HomeState(
    val isLoading: Boolean = true,
    val movieList: List<MovieEntity.Search>? = null,
)
