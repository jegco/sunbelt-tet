package com.example.persistence.services

import com.example.persistence.models.DataMovieCollection
import com.example.persistence.models.DataMovieDescription
import com.example.persistence.utils.POPULAR
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET(POPULAR)
    suspend fun getMovies(): Response<DataMovieCollection>

    @GET("{idMovie}")
    suspend fun getMovieDescription(
        @Path("idMovie") idMovie: Int
    ): Response<DataMovieDescription>

}