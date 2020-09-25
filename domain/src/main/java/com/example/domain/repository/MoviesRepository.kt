package com.example.domain.repository

import androidx.lifecycle.LiveData
import com.example.domain.models.Movie
import com.example.domain.models.MovieDescription
import com.example.domain.utils.Result

interface MoviesRepository {
    fun getMovieCollection(): LiveData<Result<List<Movie>>>

    fun getMovieDetails(
        id: Int
    ): LiveData<Result<MovieDescription>>
}