package com.galassinitecnology.movieapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.galassinitecnology.movieapp.api.model.response.movies.Movie
import com.galassinitecnology.movieapp.dao.MovieDao

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDataBase : RoomDatabase() {

    abstract val movieDao: MovieDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDataBase? = null

        fun getDatabase(context: Context): MovieDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDataBase::class.java,
                    "movie_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}