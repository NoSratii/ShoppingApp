package com.androiddev.shoppingapp.presentation.screen.home


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.data.utils.pagination.DefaultPaginator
import com.androiddev.domain.entity.response.ShoppingEntity
import com.androiddev.domain.useCase.OrderUseCase
import com.androiddev.domain.useCase.ShoppingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject
import kotlin.collections.List

@HiltViewModel
class HomeViewModel @Inject
constructor(
    private val shoppingUseCases: ShoppingUseCases,
    private val orderUseCase: OrderUseCase,
) : ViewModel() {

    var state by mutableStateOf(HomeState())
    var orderState by mutableStateOf(OrderItemsState())
    private val rightNow = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            shoppingUseCases.getPopularItemsUseCase(nextPage, 20)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                items = state.items + items,
                page = newKey,
                endReached = items.isEmpty()
            )
        }
    )


    init {
        loadOrders()
        loadShopItems()

/*        if (rightNow in 8..19) {

            loadShopItems()
        } else {
            state = state.copy(isShowShimmer = true, isShowDialog = true)
        }*/
    }

    fun loadShopItems() {
        viewModelScope.launch {
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