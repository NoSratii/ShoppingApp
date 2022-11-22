package com.androiddev.movieapp.presentation.screen.details

import androidx.lifecycle.ViewModel
import com.androiddev.domain.useCase.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases
) : ViewModel() {

/*    fun getMovieDetails(movieID: Int) {
        viewModelScope.launch {
            movieUseCases.getMoviesFromDBUseCase.invoke(movieID = movieID).collect {
                _selectedMovie.value = it
            }
        }
    }*/
}