package com.androiddev.data.repository

import com.androiddev.data.errorHandler.ErrorHandler
import com.androiddev.domain.entity.common.ResultState
import com.androiddev.domain.repository.BaseRepository
import retrofit2.Response
import javax.inject.Inject


class BaseRepositoryImpl @Inject constructor(private val errorHandler: ErrorHandler) :
    BaseRepository {

    override suspend fun <T : Any> callApi(call: suspend () -> Response<T>): ResultState<T> {
        return try {
            val response = call()
            if (response.isSuccessful)
                ResultState.Success(data = response.body(), responseCode = response.code())
            else
                ResultState.Error(error = errorHandler.getError(responseBody = response.errorBody()))
        } catch (ex: Throwable) {
            ResultState.Error(errorHandler.handleError(ex))
        }
    }
}