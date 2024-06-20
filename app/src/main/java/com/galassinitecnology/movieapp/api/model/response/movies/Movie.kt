package com.galassinitecnology.movieapp.api.model.response.movies


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity
@JsonClass(generateAdapter = true)
@Parcelize
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    @Json(name = "id")
    val id: Int?,
    @SerializedName("adult")
    @Json(name = "adult")
    val adult: Boolean?,
    @SerializedName("backdropPath")
    @Json(name = "backdropPath")
    val backdropPath: String?,
//    @SerializedName("genreIds")
//    @Json(name = "genreIds")
//    val genreIds: List<Int>?,
    @SerializedName("originalLanguage")
    @Json(name = "originalLanguage")
    val originalLanguage: String?,
    @SerializedName("originalTitle")
    @Json(name = "originalTitle")
    val originalTitle: String?,
    @SerializedName("overview")
    @Json(name = "overview")
    val overview: String?,
    @SerializedName("popularity")
    @Json(name = "popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    @Json(name = "poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    @Json(name = "release_date")
    val releaseDate: String?,
    @SerializedName("title")
    @Json(name = "title")
    val title: String?,
    @SerializedName("video")
    @Json(name = "video")
    val video: Boolean?,
    @SerializedName("vote_average")
    @Json(name = "vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    @Json(name = "vote_count")
    val voteCount: Int?,
//    @SerializedName("order")
//    @Json(name = "order")
//    val order: Int?,
//    @SerializedName("movieType")
//    @Json(name = "movieType")
//    val movieType: String?
) : Serializable, Parcelable