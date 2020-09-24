package com.example.persistence.services

import com.example.persistence.models.DataMovieCollection
import com.example.persistence.models.DataMovieDescription
import com.example.persistence.utils.POPULAR
import rx.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET(POPULAR)
    fun getMovies(@Query("language") language: String): Observable<DataMovieCollection>

    @GET("{idMovie}")
    fun getMovieDescription(
        @Path("idMovie") idMovie: String,
        @Query("language") language: String,
        @Query("append_to_response") appendToResponse: String
    ): Observable<DataMovieDescription>

}