package com.androiddev.movieapp.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.data.dto.MovieDto
import com.androiddev.domain.entity.common.ResultState
import com.androiddev.domain.entity.response.MovieEntity
import com.androiddev.domain.useCase.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases,
) : ViewModel() {

    init {
        getBatmanMovies()
    }

    private val _movies = MutableStateFlow<List<MovieEntity.Search>?>(emptyList())
    val movies: StateFlow<List<MovieEntity.Search>?> = _movies

    private fun getBatmanMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            movieUseCases.getPopularMoviesUseCase().collect { result ->
                when (result) {
                    is ResultState.Success -> {
                        _movies.emit(result.data?.search)
                    }
                    is ResultState.Error -> {}
                }
            }
        }
    }

}