package com.example.ayyan.domain.repository

import com.example.ayyan.data.remote.dto.MovieDto

interface MovieRepository {
    suspend fun getMovieListRepository(): List<MovieDto>
}