package com.androiddev.domain.entity.common

sealed class ErrorEntity {
  data class Error(
      val message: String,
      val statusCode: Int
  ) : ErrorEntity()
}
