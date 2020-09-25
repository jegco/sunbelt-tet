package com.example.sunbelttest.moviedescription

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.MovieDescription
import com.example.domain.usecases.base.UseCase
import com.example.domain.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(private val getMovieDetailsUseCase: UseCase<Int, MovieDescription>) :
    ViewModel() {
    private var movie: LiveData<Result<MovieDescription>> = MutableLiveData()

    fun getMovie() = movie

    fun fetchMovieDetail(movieId: Int) {
        viewModelScope.launch { movie = getMovieDetailsUseCase.execute(movieId) }
    }

    override fun onCleared() {
        super.onCleared()
    }
}