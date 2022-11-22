package com.androiddev.domain.repository

import com.androiddev.domain.entity.common.ResultState
import retrofit2.Response


interface BaseRepository {
  suspend fun <T : Any> callApi(call: suspend () -> Response<T>): ResultState<T>
}
