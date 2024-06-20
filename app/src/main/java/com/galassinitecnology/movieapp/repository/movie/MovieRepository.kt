package com.galassinitecnology.movieapp.repository.movie

import com.galassinitecnology.movieapp.api.model.request.MovieRequest
import com.galassinitecnology.movieapp.api.model.response.categories.CategoriesResponse
import com.galassinitecnology.movieapp.api.model.response.movies.MovieResponse
import com.galassinitecnology.movieapp.api.service.movie.MovieService
import com.galassinitecnology.movieapp.utils.ResponseParser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.lang.Exception

class MovieRepository(
    private val service: MovieService,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun getCategories(language: String): Result<CategoriesResponse?> =
        withContext(dispatcher){
            try {
                val response = service.getCategories(
                    language = language
                )
                when {

                    response.isSuccessful -> {
                        Result.success(response.body())
                    }

                    else -> {
                        Result.failure(Throwable(ResponseParser.parseError(response)))
                    }
                }
            }catch (e: Exception){
                Result.failure(Throwable(e.message))
            }
        }

    suspend fun getMoviesPlaying(post: MovieRequest): Result<MovieResponse?> =
        withContext(dispatcher){
            try {
                val response = service.getMoviesPlaying(
                    airDateGte = post.airDateGte,
                    airDateLte = post.airDateLte,
                    certification = post.certification,
                    certificationCountry = post.certificationCountry,
                    debug = post.debug,
                    firstAirDateGte = post.firstAirDateGte,
                    firstAirDateLte = post.firstAirDateLte,
                    primaryReleaseDateGte = post.primaryReleaseDateGte,
                    primaryReleaseDateLte = post.primaryReleaseDateLte,
                    releaseDateGte = post.releaseDateGte,
                    releaseDateLte = post.releaseDateLte,
                    region = post.region,
                    showMe = post.showMe,
                    sortBy = post.sortBy,
                    voteAverageGte = post.voteAverageGte,
                    voteAverageLte  = post.voteAverageLte,
                    voteCountGte = post.voteCountGte,
                    watchRegion = post.watchRegion,
                    withGenres = post.withGenres,
                    withKeywords = post.withKeywords,
                    withNetworks = post.withNetworks,
                    withOriginCountry = post.withOriginCountry,
                    withOriginalLanguage = post.withOriginalLanguage,
                    withWatchMonetizationTypes = post.withWatchMonetizationTypes,
                    withWatchProviders = post.withWatchProviders,
                    withReleaseType = post.withReleaseType,
                    withRuntimeGte = post.withRuntimeGte,
                    withRuntimeLte = post.withRuntimeLte,
                    includeAdult = post.includeAdult,
                    includeVideo = post.includeVideo,
                    language = post.language,
                    page = post.page
                )
                when {

                    response.isSuccessful -> {
                        Result.success(response.body())
                    }

                    else -> {
                        Result.failure(Throwable(ResponseParser.parseError(response)))
                    }
                }
            }catch (e: Exception){
                Result.failure(Throwable(e.message))
            }
        }

    suspend fun getMoviesPopular(post: MovieRequest): Result<MovieResponse?> =
        withContext(dispatcher){
            try {
                val response = service.getMoviesPopular(
                    airDateGte = post.airDateGte,
                    airDateLte = post.airDateLte,
                    certification = post.certification,
                    certificationCountry = post.certificationCountry,
                    debug = post.debug,
                    firstAirDateGte = post.firstAirDateGte,
                    firstAirDateLte = post.firstAirDateLte,
                    primaryReleaseDateGte = post.primaryReleaseDateGte,
                    primaryReleaseDateLte = post.primaryReleaseDateLte,
                    releaseDateGte = post.releaseDateGte,
                    releaseDateLte = post.releaseDateLte,
                    region = post.region,
                    showMe = post.showMe,
                    sortBy = post.sortBy,
                    voteAverageGte = post.voteAverageGte,
                    voteAverageLte  = post.voteAverageLte,
                    voteCountGte = post.voteCountGte,
                    watchRegion = post.watchRegion,
                    withGenres = post.withGenres,
                    withKeywords = post.withKeywords,
                    withNetworks = post.withNetworks,
                    withOriginCountry = post.withOriginCountry,
                    withOriginalLanguage = post.withOriginalLanguage,
                    withWatchMonetizationTypes = post.withWatchMonetizationTypes,
                    withWatchProviders = post.withWatchProviders,
                    withReleaseType = post.withReleaseType,
                    withRuntimeGte = post.withRuntimeGte,
                    withRuntimeLte = post.withRuntimeLte,
                    includeAdult = post.includeAdult,
                    includeVideo = post.includeVideo,
                    language = post.language,
                    page = post.page
                )
                when {

                    response.isSuccessful -> {
                        Result.success(response.body())
                    }

                    else -> {
                        Result.failure(Throwable(ResponseParser.parseError(response)))
                    }
                }
            }catch (e: Exception){
                Result.failure(Throwable(e.message))
            }
        }

    suspend fun getMoviesTop(post: MovieRequest): Result<MovieResponse?> =
        withContext(dispatcher){
            try {
                val response = service.getMoviesTop(
                    airDateGte = post.airDateGte,
                    airDateLte = post.airDateLte,
                    certification = post.certification,
                    certificationCountry = post.certificationCountry,
                    debug = post.debug,
                    firstAirDateGte = post.firstAirDateGte,
                    firstAirDateLte = post.firstAirDateLte,
                    primaryReleaseDateGte = post.primaryReleaseDateGte,
                    primaryReleaseDateLte = post.primaryReleaseDateLte,
                    releaseDateGte = post.releaseDateGte,
                    releaseDateLte = post.releaseDateLte,
                    region = post.region,
                    showMe = post.showMe,
                    sortBy = post.sortBy,
                    voteAverageGte = post.voteAverageGte,
                    voteAverageLte  = post.voteAverageLte,
                    voteCountGte = post.voteCountGte,
                    watchRegion = post.watchRegion,
                    withGenres = post.withGenres,
                    withKeywords = post.withKeywords,
                    withNetworks = post.withNetworks,
                    withOriginCountry = post.withOriginCountry,
                    withOriginalLanguage = post.withOriginalLanguage,
                    withWatchMonetizationTypes = post.withWatchMonetizationTypes,
                    withWatchProviders = post.withWatchProviders,
                    withReleaseType = post.withReleaseType,
                    withRuntimeGte = post.withRuntimeGte,
                    withRuntimeLte = post.withRuntimeLte,
                    includeAdult = post.includeAdult,
                    includeVideo = post.includeVideo,
                    language = post.language,
                    page = post.page
                )
                when {

                    response.isSuccessful -> {
                        Result.success(response.body())
                    }

                    else -> {
                        Result.failure(Throwable(ResponseParser.parseError(response)))
                    }
                }
            }catch (e: Exception){
                Result.failure(Throwable(e.message))
            }
        }

}