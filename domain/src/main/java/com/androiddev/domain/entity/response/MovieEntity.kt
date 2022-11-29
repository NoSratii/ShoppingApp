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

    data class Details(

        var title: String?,
        var tear: String?,
        var rated: String?,
        var released: String?,
        var runtime: String?,
        var genre: String?,
        var director: String?,
        var writer: String?,
        var actors: String?,
        var plot: String?,
        var language: String?,
        var country: String?,
        var awards: String?,
        var poster: String?,
        var ratings: List<Ratings>?,
        var metascore: String?,
        var imdbRating: String?,
        var imdbVotes: String?,
        var imdbID: String?,
        var type: String?,
        var dvd: String?,
        var boxOffice: String?,
        var production: String?,
        var website: String?,
        var response: String?
    ) : MovieEntity()

    data class Ratings(
        val source: String,
        val value: String
    )
}
