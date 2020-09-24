package com.example.domain.usecases

import com.example.domain.models.Movie
import com.example.domain.repository.MoviesRepository
import com.example.domain.usecases.base.UseCaseImp
import rx.Observable

import javax.inject.Inject

class GetMovieCollectionUseCase @Inject constructor(private val moviesRepository: MoviesRepository) :
    UseCaseImp<String, List<Movie?>?>() {

    override fun buildUseCase(params: String): Observable<List<Movie?>?> {
        return moviesRepository.getMovieCollection(params)
    }
}