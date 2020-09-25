package com.example.domain.usecases

import androidx.lifecycle.LiveData
import com.example.domain.models.Movie
import com.example.domain.repository.MoviesRepository
import com.example.domain.usecases.base.UseCaseImp
import com.example.domain.utils.Result
import javax.inject.Inject

class GetMovieCollectionUseCase @Inject constructor(private val moviesRepository: MoviesRepository) :
    UseCaseImp<String, List<Movie>>() {

    override fun buildUseCase(params: String): LiveData<Result<List<Movie>>> =
        moviesRepository.getMovieCollection()
}