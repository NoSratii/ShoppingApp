package com.androiddev.shoppingapp.presentation.screen.home


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.data.utils.pagination.DefaultPaginator
import com.androiddev.domain.useCase.ShoppingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject
constructor(
    private val shoppingUseCases: ShoppingUseCases,
) : ViewModel() {

    var state by mutableStateOf(HomeState())
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
        if (rightNow in 8..19) {
            loadShopItems()
        } else {
            state = state.copy(isLoading = true, isShowDialog = true)
        }
    }

    fun loadShopItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

}