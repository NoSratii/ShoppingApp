package com.androiddev.movieapp.presentation.screen.home


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class HomeViewModel @Inject
constructor(
    private val movieUseCases: MovieUseCases,
) : ViewModel() {

    init {
       getBatmanMovies()
    }

    var state by mutableStateOf(HomeState())
    private val _movies = MutableStateFlow<List<MovieEntity.Search>?>(emptyList())
    val movies: MutableStateFlow<List<MovieEntity.Search>?> = _movies

    private fun getBatmanMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            movieUseCases.getPopularMoviesUseCase().collect { result ->
                when (result) {
                    is ResultState.Success -> {
                        state = state.copy(isLoading = false , movieList = result.data?.search)
                        _movies.emit(result.data?.search)
                    }
                    is ResultState.Error -> {
                        state = state.copy(isLoading = false)
                        Log.e("2729", "getBatmanMoviesError:$ ", )
                    }
                }
            }
        }
    }

}