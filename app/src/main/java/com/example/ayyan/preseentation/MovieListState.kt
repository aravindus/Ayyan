package com.example.ayyan.preseentation

import com.example.ayyan.domain.model.MovieData

data class MovieListState(
    val isLoading: Boolean = false,
    val movieList: List<MovieData> = emptyList(),
    val error: String = ""
)