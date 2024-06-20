package com.galassinitecnology.movieapp.api.model.response.movies


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class Dates(
    @SerializedName("maximum")
    @Json(name = "maximum")
    val maximum: String,
    @SerializedName("minimum")
    @Json(name = "minimum")
    val minimum: String
) : Serializable