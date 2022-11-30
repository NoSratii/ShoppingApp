package com.androiddev.shoppingapp.presentation.screen.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.domain.useCase.OrderUseCase
import com.androiddev.shoppingapp.util.Constant
import com.androiddev.shoppingapp.util.Constant.SHOPPING_DETAILS_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val orderUseCase: OrderUseCase,
    savedStateHandle: SavedStateHandle

) : ViewModel() {

    var state by mutableStateOf(DetailsState())

    init {
        getSaveHandleState(savedStateHandle)
    }


    private fun getSaveHandleState(savedStateHandle: SavedStateHandle) {
        if (savedStateHandle.contains(Constant.SHOPPING_DETAILS_ARGUMENT_KEY)) {

            loadDetails(checkNotNull(savedStateHandle[SHOPPING_DETAILS_ARGUMENT_KEY]))

        }
    }


    fun loadDetails(itemId: Long) {
        viewModelScope.launch {
            orderUseCase.getOrderItems()
                .collect { items ->
                    val itemDetail = items
                        .filter { it.id > itemId }

                    state = state.copy(
                        orderItems = itemDetail,
                    )

                }
        }
    }
}