package com.example.persistence.repositories

import com.example.domain.models.Movie
import com.example.domain.models.MovieDescription
import com.example.domain.repository.MoviesRepository
import com.example.persistence.services.MoviesService
import com.example.persistence.utils.toDomainEntity
import com.example.persistence.utils.toListOfMovies
import rx.Observable
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(
    private val moviesService: MoviesService
) : MoviesRepository {

    override fun getMovieCollection(languaje: String): Observable<List<Movie?>?> =
        moviesService.getMovies(languaje).map { dataMovies -> dataMovies.toListOfMovies() }

    override fun getMovieDetails(
        id: String,
        languaje: String,
        appendToResponse: String
    ): Observable<MovieDescription> =
        moviesService
            .getMovieDescription(id, languaje, appendToResponse)
            .map { dataMovieDescription -> dataMovieDescription.toDomainEntity() }

}