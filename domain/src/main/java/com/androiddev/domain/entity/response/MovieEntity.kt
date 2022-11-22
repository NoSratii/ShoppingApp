package com.androiddev.domain.entity.response

sealed class MovieEntity {

    data class BatmanMovie(
        val search: List<Search>?,
        val totalResults: String?,
        val response: String?,
    ) : MovieEntity()

    data class Search(
        var title: String?,
        var year: String?,
        var imdbID: String?,
        var type: String?,
        var poster: String?,
    ) : MovieEntity()

}
