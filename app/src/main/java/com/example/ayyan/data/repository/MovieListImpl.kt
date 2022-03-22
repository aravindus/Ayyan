package com.example.ayyan.data.repository

import com.example.ayyan.data.remote.MovieListApi
import com.example.ayyan.data.remote.dto.MovieDto
import com.example.ayyan.domain.repository.MovieRepository
import javax.inject.Inject

class MovieListImpl @Inject constructor(
    private val api: MovieListApi
) : MovieRepository {
    override suspend fun getMovieListRepository(): List<MovieDto> {
        return api.getMovieListFromServer()
    }
}