package com.galassinitecnology.movieapp.api.model.request

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieRequest(
    val airDateGte: String? = null,
    val airDateLte: String? = null,
    val certification: String? = null,
    val certificationCountry: String? = null,
    val debug: String? = null,
    val firstAirDateGte: String? = null,
    val firstAirDateLte: String? = null,
    val primaryReleaseDateGte: String? = null,
    val primaryReleaseDateLte: String? = null,
    val releaseDateGte: String? = null,
    val releaseDateLte: String? = null,
    val region: String? = null,
    val showMe: Int? = null,
    val sortBy: String? = "popularity.desc",
    val voteAverageGte: Int? = null,
    val voteAverageLte: Int? = null,
    val voteCountGte: Int? = null,
    val watchRegion: String? = null,
    val withGenres: String? = null,
    val withKeywords: String? = null,
    val withNetworks: String? = null,
    val withOriginCountry: String? = null,
    val withOriginalLanguage: String? = null,
    val withWatchMonetizationTypes: String? = null,
    val withWatchProviders: String? = null,
    val withReleaseType: Int? = null,
    val withRuntimeGte: Int? = null,
    val withRuntimeLte: Int? = null,
    val includeAdult: Boolean? = false,
    val includeVideo: Boolean? = false,
    val language: String? = "en-US",
    val page: Int? = 1
)
