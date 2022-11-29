package com.androiddev.data.dto.common

import com.squareup.moshi.Json

data class ErrorDto(
    @field:Json(name = "status") val errorCode: Int?,
    @field:Json(name = "detail") val details: String?
)
