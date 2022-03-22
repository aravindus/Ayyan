package com.example.ayyan.data.remote

import com.example.ayyan.data.remote.dto.MovieDto
import retrofit2.http.GET

interface MovieListApi {
    @GET("movielist.json")
    suspend fun getMovieListFromServer():List<MovieDto>

}