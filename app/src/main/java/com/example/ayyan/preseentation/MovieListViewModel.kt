package com.example.ayyan.preseentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ayyan.common.Resources
import com.example.ayyan.domain.model.MovieData
import com.example.ayyan.domain.use_case.MovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: MovieListUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

/*    private val movieListState = mutableStateOf(MovieListState())
    val state: State<MovieListState> = movieListState*/
    val movieList = MutableLiveData<List<MovieData>>()

    init {
        getMovieListViewModel()
    }

    private fun getMovieListViewModel() {
        getMovieListUseCase().onEach { resources ->
            when (resources) {
                is Resources.Success -> {
                    movieList.postValue(resources.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)


        /* private fun getMovieListViewModel() {
         getMovieListUseCase().onEach { resources ->
             when (resources) {
                 is Resources.Success -> {
                     movieListState.value = MovieListState(movieList = resources.data ?: emptyList())
                 }
                 is Resources.Error -> {
                     movieListState.value =
                         MovieListState(error = resources.message ?: "An error occured")
                 }
                 is Resources.Loading -> {
                     movieListState.value = MovieListState(isLoading = true)
                 }
             }
         }.launchIn(viewModelScope)
     }*/
    }
}