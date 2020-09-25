package com.example.domain.usecases

import androidx.lifecycle.LiveData
import com.example.domain.models.MovieDescription
import com.example.domain.repository.MoviesRepository
import com.example.domain.usecases.base.UseCaseImp
import com.example.domain.utils.Result
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val moviesRepository: MoviesRepository) :
    UseCaseImp<Int, MovieDescription>() {

    override fun buildUseCase(params: Int): LiveData<Result<MovieDescription>> =
        moviesRepository.getMovieDetails(params)
}