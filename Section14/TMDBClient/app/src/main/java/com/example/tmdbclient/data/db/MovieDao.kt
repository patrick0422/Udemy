package com.example.tmdbclient.data.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.tmdbclient.data.model.movie.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>
}