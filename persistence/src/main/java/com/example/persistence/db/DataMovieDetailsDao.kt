package com.example.persistence.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.persistence.models.db.*

@Dao
abstract class DataMovieDetailsDao {

    @Transaction
    @Query("SELECT * FROM movie_details where id = :id")
    abstract fun getMovieById(id: Int): LiveData<EntityDescriptionWithJoins>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieDescription: EntityDescriptionWithJoins) {
        val id = insertMovieDetails(movieDescription.description).toInt()
        movieDescription.belongsToCollection?.let {
            it.id = id
            insertBelongsToCollection(it)
        }

        movieDescription.genres?.let {
            it.map { genre -> genre.idMovie = id }
            insertAllGenres(it)
        }

        movieDescription.videos?.let {
            it.map { video -> video.idMovie = id }
            insertAllVideos(it)
        }

        movieDescription.spokenLanguages?.let {
            it.map { spokenLang -> spokenLang.idMovie = id }
            insertAllSpokenLanguages(it)
        }

        movieDescription.productionCompanies?.let {
            it.map { prodComp -> prodComp.idMovie = id }
            insertAllProductionCompanies(it)
        }

        movieDescription.productionCountries?.let {
            it.map { prodCountry -> prodCountry.idMovie = id }
            insertAllProductionCountries(it)
        }

    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertMovieDetails(description: EntityMovieDescription): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertBelongsToCollection(belongsToCollection: EntityBelongsToCollection)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAllGenres(genres: List<EntityGenre>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAllVideos(genres: List<EntityVideo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAllSpokenLanguages(genres: List<EntitySpokenLanguage>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAllProductionCompanies(genres: List<EntityProductionCompany>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAllProductionCountries(genres: List<EntityProductionCountry>)
}