package com.galassinitecnology.movieapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.galassinitecnology.movieapp.api.model.response.movies.Movie

@Dao
abstract class MovieDao: BaseDao<Movie> {

    @Query("SELECT * FROM movie")
    abstract suspend fun getAll(): List<Movie>?

    @Query("SELECT * FROM movie where id=:id")
    abstract suspend fun getById(id: Int): Movie?

    @Query("DELETE FROM movie")
    abstract suspend fun deleteAll()

}