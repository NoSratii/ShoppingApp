package com.androiddev.data.dto

import com.squareup.moshi.Json

sealed class MovieDto() {

    data class BatmanMovie(
        @field:Json(name = "Search") var search: List<Search>?,
        @field:Json(name = "totalResults") var totalResults: String?,
        @field:Json(name = "Response") var response: String?,
    ) : MovieDto()


    data class Search(
        @field:Json(name = "Title") var title: String?,
        @field:Json(name = "Year") var year: String?,
        @field:Json(name = "imdbID") var imdbID: String?,
        @field:Json(name = "Type") var type: String?,
        @field:Json(name = "Poster") var poster: String?,
    ) : MovieDto()
}
