package com.example.persistence.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.persistence.models.DataMovie
import com.example.persistence.models.db.*

@Database(
    entities = [
        EntityMovie::class,
        EntityMovieDescription::class,
        EntityGenre::class,
        EntitySpokenLanguage::class,
        EntityProductionCompany::class,
        EntityProductionCountry::class,
        EntityVideo::class,
        EntityBelongsToCollection::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): DataMovieDao

    abstract fun movieDetailsDao(): DataMovieDetailsDao
}