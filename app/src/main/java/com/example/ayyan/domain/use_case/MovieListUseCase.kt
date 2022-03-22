package com.example.ayyan.domain.use_case

import com.example.ayyan.common.Resources
import com.example.ayyan.data.remote.dto.toModelData
import com.example.ayyan.domain.model.MovieData
import com.example.ayyan.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieListUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<Resources<List<MovieData>>> = flow {

        try {
            emit(Resources.Loading())
            val movieList = repository.getMovieListRepository().map { it.toModelData() }
            emit(Resources.Success(movieList))
        } catch (e: HttpException) {
            emit(Resources.Error(e.localizedMessage ?: "Internet connection failed"))
        } catch (e: IOException) {

            emit(Resources.Error(e.localizedMessage ?: "IO connection failed"))
        }
    }
}