package com.example.persistence.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.domain.models.Movie
import com.example.domain.models.MovieDescription
import com.example.domain.repository.MoviesRepository
import com.example.domain.utils.Result
import com.example.persistence.db.DataMovieDao
import com.example.persistence.db.DataMovieDetailsDao
import com.example.persistence.services.MoviesService
import com.example.persistence.utils.toDbEntity
import com.example.persistence.utils.toDomainEntity
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(
    private val moviesService: MoviesService,
    private val movieDao: DataMovieDao,
    private val movieDetailsDao: DataMovieDetailsDao
) : MoviesRepository {

    override fun getMovieCollection(): LiveData<Result<List<Movie>>> =
        liveData(Dispatchers.IO) {
            emit(Result.loading(null))
            val movies = movieDao.getMovies().value?.map { dataMovie -> dataMovie.toDomainEntity() }
            if (movies != null) emit(Result.success(movies))
            else {
                val fetchedMovies = moviesService.getMovies()
                if (fetchedMovies.isSuccessful) {
                    fetchedMovies.body()?.let {
                        val movies = it.movies.map { dataMovie -> dataMovie.toDomainEntity() }
                        emit(Result.success(movies))
                        movieDao.insertAll(it.movies.map { entity -> entity.toDbEntity() })
                    }
                } else emit(Result.error("Error retreiving movie list", null))
            }
        }


    override fun getMovieDetails(
        id: Int
    ): LiveData<Result<MovieDescription>> = liveData(Dispatchers.IO) {
        emit(Result.loading(null))
        val movie = movieDetailsDao.getMovieById(id)
            .map { dataMovieDescription -> dataMovieDescription.toDomainEntity() }.value
        if (movie != null) emit(Result.success(movie))
        else {
            val fetchedMovie = moviesService.getMovieDescription(id)
            if (fetchedMovie.isSuccessful) {
                fetchedMovie.body()?.let {
                    val movie = it.toDomainEntity()
                    emit(Result.success(movie))
                    // movieDetailsDao.insert(it)
                }
            } else emit(Result.error("Error retreiving movie details", null))
        }
    }

}