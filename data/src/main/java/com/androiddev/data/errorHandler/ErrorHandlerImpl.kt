package com.androiddev.data.errorHandler

import android.util.MalformedJsonException
import com.androiddev.data.dto.ErrorDto
import com.androiddev.domain.entity.common.ErrorEntity
import com.androiddev.data.constant.NetworkConstants
import com.squareup.moshi.Moshi
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.io.InterruptedIOException
import java.net.SocketException
import java.net.SocketTimeoutException
import javax.inject.Inject


class ErrorHandlerImpl @Inject constructor(private val moshiBuilder: Moshi.Builder) : ErrorHandler {

    override fun handleError(throwable: Throwable): ErrorEntity.Error {
        return when (throwable) {
            is SocketTimeoutException, is SocketException, is InterruptedIOException -> {
                ErrorEntity.Error(
                    statusCode = NetworkConstants.NETWORK_ERROR_CODES.SERVICE_UNAVAILABLE,
                    message = NetworkConstants.NETWORK_ERROR_MESSAGES.SERVICE_UNAVAILABLE
                )
            }

            is MalformedJsonException -> {
                ErrorEntity.Error(
                    statusCode = NetworkConstants.NETWORK_ERROR_CODES.MALFORMED_JSON,
                    message = NetworkConstants.NETWORK_ERROR_MESSAGES.MALFORMED_JSON
                )
            }
            is IOException -> {
                ErrorEntity.Error(
                    statusCode = NetworkConstants.NETWORK_ERROR_CODES.NO_INTERNET,
                    message = NetworkConstants.NETWORK_ERROR_MESSAGES.NO_INTERNET
                )
            }

            is HttpException -> {
                getError(throwable.response()?.errorBody())
            }
            else -> {
                ErrorEntity.Error(
                    statusCode = NetworkConstants.NETWORK_ERROR_CODES.UNEXPECTED_ERROR,
                    message = NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR
                )
            }
        }
    }

    override fun getError(responseBody: ResponseBody?): ErrorEntity.Error {
        return try {

            val moshiAdapter: com.squareup.moshi.JsonAdapter<ErrorDto> = moshiBuilder.build().adapter(
                ErrorDto::class.java
            )
            val error = moshiAdapter.fromJson(responseBody?.string() ?: "")

            ErrorEntity.Error(
                message = error?.details
                    ?: NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR,
                statusCode = error?.errorCode
                    ?: NetworkConstants.NETWORK_ERROR_CODES.UNEXPECTED_ERROR
            )

        } catch (ex: Exception) {
            ErrorEntity.Error(
                message = NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR,
                statusCode = NetworkConstants.NETWORK_ERROR_CODES.UNEXPECTED_ERROR
            )
        }
    }
}