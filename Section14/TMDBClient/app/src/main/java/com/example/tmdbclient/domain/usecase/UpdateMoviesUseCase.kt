package com.example.tmdbclient.domain

import com.example.tmdbclient.data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun updateMovies(): List<Movie>? = movieRepository.updateMovies()
}