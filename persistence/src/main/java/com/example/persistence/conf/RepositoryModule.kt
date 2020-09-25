package com.example.persistence.conf

import com.example.domain.repository.MoviesRepository
import com.example.persistence.db.DataMovieDao
import com.example.persistence.db.DataMovieDetailsDao
import com.example.persistence.repositories.MoviesRepositoryImp
import com.example.persistence.services.MoviesService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesMoviesCollectionRepository(
        moviesService: MoviesService,
        movieDao: DataMovieDao,
        movieDetailsDao: DataMovieDetailsDao
    ):
            MoviesRepository = MoviesRepositoryImp(moviesService, movieDao, movieDetailsDao)
}