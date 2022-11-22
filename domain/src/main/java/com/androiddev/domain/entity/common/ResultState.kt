package com.androiddev.domain.entity.common


sealed class ResultState<T> {
    data class Success<T>(val data: T?, val responseCode: Int) : ResultState<T>()
    data class Error<T>(val error: ErrorEntity.Error) : ResultState<T>()
}