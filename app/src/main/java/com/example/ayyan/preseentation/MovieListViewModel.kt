package com.example.ayyan.preseentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ayyan.domain.model.MovieData
import com.example.ayyan.domain.use_case.MovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: MovieListUseCase
) : ViewModel() {
    val movieList = MutableLiveData<List<MovieData>>()

    init {
        getMovieListViewModel()
    }

    private fun getMovieListViewModel() {
        getMovieListUseCase().onEach { resources ->
            movieList.postValue(resources.data ?: emptyList())
        }.launchIn(viewModelScope)
    }
}