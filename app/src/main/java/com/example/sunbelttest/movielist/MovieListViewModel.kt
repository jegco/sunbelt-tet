package com.example.sunbelttest.movielist

import androidx.lifecycle.*
import com.example.domain.models.Movie
import com.example.domain.usecases.base.UseCase
import com.example.domain.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val getMovieCollectionUseCase: UseCase<String, List<Movie>>) :
    ViewModel() {

    private var movieList: LiveData<Result<List<Movie>>> = MutableLiveData()

    fun getMovies() = movieList

    fun fetchMovies() {
        viewModelScope.launch { movieList = getMovieCollectionUseCase.execute("") }
    }

    override fun onCleared() {
        super.onCleared()
    }
}