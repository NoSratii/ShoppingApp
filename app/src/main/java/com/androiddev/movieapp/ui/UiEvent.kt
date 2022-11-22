package com.androiddev.movieapp.ui

import com.androiddev.movieapp.util.UiText

sealed class UiEvent{
    data class ShowSnackbar(val title: UiText, val message: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()
}
