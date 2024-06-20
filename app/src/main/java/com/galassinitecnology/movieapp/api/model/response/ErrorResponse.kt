package com.galassinitecnology.movieapp.api.model.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    val error: String
)
