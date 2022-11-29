package com.androiddev.shoppingapp.presentation.screen.details

import androidx.lifecycle.ViewModel
import com.androiddev.domain.useCase.ShoppingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val shoppingUseCases: ShoppingUseCases
) : ViewModel() {

}