package com.example.sunbelttest.conf

import com.example.domain.models.Movie
import com.example.domain.repository.MoviesRepository
import com.example.domain.usecases.GetMovieCollectionUseCase
import com.example.domain.usecases.base.UseCase
import com.example.persistence.conf.BuildConf
import com.example.sunbelttest.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetMovieCollectionUseCase(moviesRepository: MoviesRepository): UseCase<String, List<Movie?>?> =
        GetMovieCollectionUseCase(moviesRepository)
}