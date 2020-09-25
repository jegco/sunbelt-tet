package com.example.persistence.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.persistence.models.db.EntityMovie

@Dao
interface DataMovieDao {

    @Query("SELECT * FROM movie ORDER BY id DESC")
    fun getMovies(): LiveData<List<EntityMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<EntityMovie>)
}