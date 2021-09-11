package com.example.tmdbclient.domain

import com.example.tmdbclient.data.model.artist.Artist

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}