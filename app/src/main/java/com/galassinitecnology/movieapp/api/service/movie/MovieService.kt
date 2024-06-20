package com.galassinitecnology.movieapp.api.service.movie

import com.galassinitecnology.movieapp.api.model.response.categories.CategoriesResponse
import com.galassinitecnology.movieapp.api.model.response.movies.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("discover/tv")
    suspend fun getTVAiringToday(
        @Query("air_date.gte") airDateGte: String?,
        @Query("air_date.lte") airDateLte: String?,
        @Query("certification") certification: String?,
        @Query("certification_country") certificationCountry: String?,
        @Query("debug") debug: String?,
        @Query("first_air_date.gte") firstAirDateGte: String?,
        @Query("first_air_date.lte") firstAirDateLte: String?,
        @Query("page") page: Int?,
        @Query("primary_release_date.gte") primaryReleaseDateGte: String?,
        @Query("primary_release_date.lte") primaryReleaseDateLte: String?,
        @Query("region") region: String?,
        @Query("release_date.gte") releaseDateGte: String?,
        @Query("release_date.lte") releaseDateLte: String?,
        @Query("show_me") showMe: Int?,
        @Query("sort_by") sortBy: String?,
        @Query("vote_average.gte") voteAverageGte: Int?,
        @Query("vote_average.lte") voteAverageLte: Int?,
        @Query("vote_count.gte") voteCountGte: Int?,
        @Query("watch_region") watchRegion: String?,
        @Query("with_genres") withGenres: String?,
        @Query("with_keywords") withKeywords: String?,
        @Query("with_networks") withNetworks: String?,
        @Query("with_origin_country") withOriginCountry: String?,
        @Query("with_original_language") withOriginalLanguage: String?,
        @Query("with_watch_monetization_types") withWatchMonetizationTypes: String?,
        @Query("with_watch_providers") withWatchProviders: String?,
        @Query("with_release_type") withReleaseType: Int?,
        @Query("with_runtime.gte") withRuntimeGte: Int?,
        @Query("with_runtime.lte") withRuntimeLte: Int?,
        @Query("include_adult") includeAdult: Boolean?,
        @Query("include_video") includeVideo: Boolean?,
        @Query("language") language: String?,

    )

    @GET("genre/movie/list")
    suspend fun getCategories(
        @Query("language") language: String
    ) : Response<CategoriesResponse>

    @GET("discover/movie")
    suspend fun getMoviesPlaying(
        @Query("air_date.gte") airDateGte: String?,
        @Query("air_date.lte") airDateLte: String?,
        @Query("certification") certification: String?,
        @Query("certification_country") certificationCountry: String?,
        @Query("debug") debug: String?,
        @Query("first_air_date.gte") firstAirDateGte: String?,
        @Query("first_air_date.lte") firstAirDateLte: String?,
        @Query("primary_release_date.gte") primaryReleaseDateGte: String?,
        @Query("primary_release_date.lte") primaryReleaseDateLte: String?,
        @Query("release_date.gte") releaseDateGte: String?,
        @Query("release_date.lte") releaseDateLte: String?,
        @Query("region") region: String?,
        @Query("show_me") showMe: Int?,
        @Query("sort_by") sortBy: String?,
        @Query("vote_average.gte") voteAverageGte: Int?,
        @Query("vote_average.lte") voteAverageLte: Int?,
        @Query("vote_count.gte") voteCountGte: Int?,
        @Query("watch_region") watchRegion: String?,
        @Query("with_genres") withGenres: String?,
        @Query("with_keywords") withKeywords: String?,
        @Query("with_networks") withNetworks: String?,
        @Query("with_origin_country") withOriginCountry: String?,
        @Query("with_original_language") withOriginalLanguage: String?,
        @Query("with_watch_monetization_types") withWatchMonetizationTypes: String?,
        @Query("with_watch_providers") withWatchProviders: String?,
        @Query("with_release_type") withReleaseType: Int?,
        @Query("with_runtime.gte") withRuntimeGte: Int?,
        @Query("with_runtime.lte") withRuntimeLte: Int?,
        @Query("include_adult") includeAdult: Boolean?,
        @Query("include_video") includeVideo: Boolean?,
        @Query("language") language: String?,
        @Query("page") page: Int?,
    ) : Response<MovieResponse>

    @GET("discover/movie")
    suspend fun getMoviesPopular(
        @Query("air_date.gte") airDateGte: String?,
        @Query("air_date.lte") airDateLte: String?,
        @Query("certification") certification: String?,
        @Query("certification_country") certificationCountry: String?,
        @Query("debug") debug: String?,
        @Query("first_air_date.gte") firstAirDateGte: String?,
        @Query("first_air_date.lte") firstAirDateLte: String?,
        @Query("primary_release_date.gte") primaryReleaseDateGte: String?,
        @Query("primary_release_date.lte") primaryReleaseDateLte: String?,
        @Query("release_date.gte") releaseDateGte: String?,
        @Query("release_date.lte") releaseDateLte: String?,
        @Query("region") region: String?,
        @Query("show_me") showMe: Int?,
        @Query("sort_by") sortBy: String?,
        @Query("vote_average.gte") voteAverageGte: Int?,
        @Query("vote_average.lte") voteAverageLte: Int?,
        @Query("vote_count.gte") voteCountGte: Int?,
        @Query("watch_region") watchRegion: String?,
        @Query("with_genres") withGenres: String?,
        @Query("with_keywords") withKeywords: String?,
        @Query("with_networks") withNetworks: String?,
        @Query("with_origin_country") withOriginCountry: String?,
        @Query("with_original_language") withOriginalLanguage: String?,
        @Query("with_watch_monetization_types") withWatchMonetizationTypes: String?,
        @Query("with_watch_providers") withWatchProviders: String?,
        @Query("with_release_type") withReleaseType: Int?,
        @Query("with_runtime.gte") withRuntimeGte: Int?,
        @Query("with_runtime.lte") withRuntimeLte: Int?,
        @Query("include_adult") includeAdult: Boolean?,
        @Query("include_video") includeVideo: Boolean?,
        @Query("language") language: String?,
        @Query("page") page: Int?,
    ) : Response<MovieResponse>

    @GET("discover/movie")
    suspend fun getMoviesTop(
        @Query("air_date.gte") airDateGte: String?,
        @Query("air_date.lte") airDateLte: String?,
        @Query("certification") certification: String?,
        @Query("certification_country") certificationCountry: String?,
        @Query("debug") debug: String?,
        @Query("first_air_date.gte") firstAirDateGte: String?,
        @Query("first_air_date.lte") firstAirDateLte: String?,
        @Query("primary_release_date.gte") primaryReleaseDateGte: String?,
        @Query("primary_release_date.lte") primaryReleaseDateLte: String?,
        @Query("release_date.gte") releaseDateGte: String?,
        @Query("release_date.lte") releaseDateLte: String?,
        @Query("region") region: String?,
        @Query("show_me") showMe: Int?,
        @Query("sort_by") sortBy: String?,
        @Query("vote_average.gte") voteAverageGte: Int?,
        @Query("vote_average.lte") voteAverageLte: Int?,
        @Query("vote_count.gte") voteCountGte: Int?,
        @Query("watch_region") watchRegion: String?,
        @Query("with_genres") withGenres: String?,
        @Query("with_keywords") withKeywords: String?,
        @Query("with_networks") withNetworks: String?,
        @Query("with_origin_country") withOriginCountry: String?,
        @Query("with_original_language") withOriginalLanguage: String?,
        @Query("with_watch_monetization_types") withWatchMonetizationTypes: String?,
        @Query("with_watch_providers") withWatchProviders: String?,
        @Query("with_release_type") withReleaseType: Int?,
        @Query("with_runtime.gte") withRuntimeGte: Int?,
        @Query("with_runtime.lte") withRuntimeLte: Int?,
        @Query("include_adult") includeAdult: Boolean?,
        @Query("include_video") includeVideo: Boolean?,
        @Query("language") language: String?,
        @Query("page") page: Int?,
    ) : Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US"
    ) : Response<MovieResponse>

}