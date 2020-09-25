package com.example.sunbelttest.conf

import com.example.domain.models.Movie
import com.example.domain.models.MovieDescription
import com.example.domain.repository.MoviesRepository
import com.example.domain.usecases.GetMovieCollectionUseCase
import com.example.domain.usecases.GetMovieDetailsUseCase
import com.example.domain.usecases.base.UseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMovieCollectionUseCase(moviesRepository: MoviesRepository): UseCase<String, List<Movie>> =
        GetMovieCollectionUseCase(moviesRepository)

    @Provides
    @Singleton
    fun provideGetMovieDetailsUseCase(moviesRepository: MoviesRepository): UseCase<Int, MovieDescription> =
        GetMovieDetailsUseCase(moviesRepository)
}