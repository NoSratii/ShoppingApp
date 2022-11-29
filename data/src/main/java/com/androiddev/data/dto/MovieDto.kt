package com.androiddev.data.dto
import com.squareup.moshi.Json

sealed class MovieDto() {

    data class BatmanMovie(
        @field:Json(name = "Search") var search: List<Search>?,
        @field:Json(name = "totalResults") var totalResults: String?,
    ) : MovieDto()


    data class Search(
        @field:Json(name = "Title") var title: String?,
        @field:Json(name = "Year") var year: String?,
        @field:Json(name = "imdbID") var imdbID: String?,
        @field:Json(name = "Type") var type: String?,
        @field:Json(name = "Poster") var poster: String?,
    ) : MovieDto()

    data class Details(
        @field:Json(name = "Actors") var actors: String?,
        @field:Json(name = "Awards") var awards: String?,
        @field:Json(name = "BoxOffice") var boxOffice: String?,
        @field:Json(name = "Country") var country: String?,
        @field:Json(name = "DVD") var dvd: String?,
        @field:Json(name = "Director") var director: String?,
        @field:Json(name = "Genre") var genre: String?,
        @field:Json(name = "Language") var language: String?,
        @field:Json(name = "MetaScore") var metaScore: String?,
        @field:Json(name = "Poster") var poster: String?,
        @field:Json(name = "Production") var production: String?,
        @field:Json(name = "Rated") var rated: String?,
        @field:Json(name = "Ratings") var ratings: List<RatingDto>?,
        @field:Json(name = "Released") var released: String?,
        @field:Json(name = "Response") var response: String?,
        @field:Json(name = "Runtime") var runtime: String?,
        @field:Json(name = "Title") var title: String?,
        @field:Json(name = "Type") var type: String?,
        @field:Json(name = "Website") var website: String?,
        @field:Json(name = "Year") var year: String?,
        @field:Json(name = "imdbID") var imdbID: String?,
        @field:Json(name = "imdbRating") var imdbRating: String?,
        @field:Json(name = "imdbVotes") var imdbVotes: String?,
    ) : MovieDto()


    data class RatingDto(
        @field:Json(name = "Source") var source: String?,
        @field:Json(name = "Value") var salue: String?,

        ) : MovieDto()
}
