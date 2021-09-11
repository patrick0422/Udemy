package com.example.tmdbclient.data


import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>
)