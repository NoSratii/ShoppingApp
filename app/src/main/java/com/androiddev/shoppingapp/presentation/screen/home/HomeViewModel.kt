package com.androiddev.shoppingapp.presentation.screen.home


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.domain.useCase.OrderUseCase
import com.androiddev.domain.useCase.ShoppingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject
constructor(
    private val shoppingUseCases: ShoppingUseCases,
    private val orderUseCase: OrderUseCase,
) : ViewModel() {

    var state by mutableStateOf(HomeState())
    var orderState by mutableStateOf(OrderItemsState())
    private val rightNow = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)


    init {

        if (rightNow in 8..19) {

            loadOrders()
            loadShopItems()
        } else {
            state = state.copy(isLoading = true, isShowDialog = true)
        }
    }

    fun loadShopItems() {
        viewModelScope.launch {
            delay(2000)
            state = state.copy(isLoading = false, isShowDialog = false)

            state = state.copy(
                items = shoppingUseCases.getShoppingItems()
            )
        }
    }


    fun addShoppingItem(id: Long) {
        viewModelScope.launch {
            orderUseCase.add(id)
                .collect { isAdded ->
                    if (isAdded) {
                        loadOrders()
                    }
                }
        }
    }

    fun removeShoppingItem(id: Long) {
        viewModelScope.launch {
            orderUseCase.remove(id)
                .collect { isRemoved ->
                    if (isRemoved) {
                        loadOrders()
                    }
                }
        }
    }


    fun loadOrders() {
        viewModelScope.launch {
            orderUseCase.getOrderItems()
                .collect { items ->
                    val totalCount = items
                        .filter { it.count > 0 }
                        .map { it.count * it.price }
                        .sum()

                    orderState = orderState.copy(
                        orderItems = items,
                        totalPrice = BigDecimal(totalCount)

                    )

                }
        }
    }
}