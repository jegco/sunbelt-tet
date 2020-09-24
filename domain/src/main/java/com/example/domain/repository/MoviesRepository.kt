package com.example.domain.repository

import com.example.domain.models.Movie
import com.example.domain.models.MovieDescription
import rx.Observable

interface MoviesRepository {
    fun getMovieCollection(languaje: String): Observable<List<Movie?>?>

    fun getMovieDetails(id: String, languaje: String, appendToResponse: String): Observable<MovieDescription>
}