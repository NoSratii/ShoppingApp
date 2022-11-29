package com.androiddev.shoppingapp.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.shoppingapp.presentation.navigation.Screen
import com.androiddev.shoppingapp.ui.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {


    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch(Dispatchers.Main) {
            if (true) {

                _eventFlow.emit(UiEvent.Navigate(Screen.HomeScreen.route))
            }

        }
    }

}