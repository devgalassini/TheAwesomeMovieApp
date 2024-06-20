package com.galassinitecnology.movieapp.api.model.response.categories


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoriesResponse(
    @Json(name = "genres")
    val genres: List<Genre>
)