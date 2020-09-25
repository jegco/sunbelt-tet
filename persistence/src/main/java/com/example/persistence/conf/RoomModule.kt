package com.example.persistence.conf

import android.content.Context
import androidx.room.Room
import com.example.persistence.db.AppDatabase
import com.example.persistence.db.DataMovieDao
import com.example.persistence.db.DataMovieDetailsDao
import com.example.persistence.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .build()


    @Singleton
    @Provides
    fun providesMovieDao(db: AppDatabase): DataMovieDao {
        return db.movieDao()
    }

    @Singleton
    @Provides
    fun providesMovieDetailsDao(db: AppDatabase): DataMovieDetailsDao {
        return db.movieDetailsDao()
    }
}