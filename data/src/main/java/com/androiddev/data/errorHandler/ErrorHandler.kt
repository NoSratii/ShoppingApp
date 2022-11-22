package com.androiddev.data.errorHandler

import com.androiddev.domain.entity.common.ErrorEntity
import okhttp3.ResponseBody

interface ErrorHandler {
    fun handleError(throwable: Throwable): ErrorEntity.Error
    fun getError(responseBody: ResponseBody?): ErrorEntity.Error
}