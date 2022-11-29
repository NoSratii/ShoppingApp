package com.androiddev.shoppingapp.ui

import com.androiddev.shoppingapp.util.UiText

sealed class UiEvent{
    data class ShowSnackbar(val title: UiText, val message: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()
}
