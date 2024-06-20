package com.galassinitecnology.movieapp.api.model.response.movies


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    @Json(name = "dates")
    val dates: Dates?,
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    var results: List<Movie>? = null,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)