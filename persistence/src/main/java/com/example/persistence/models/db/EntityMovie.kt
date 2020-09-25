package com.example.persistence.models.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class EntityMovie(
    @PrimaryKey
    @field:SerializedName("id") val id: Int?,
    @field:SerializedName("title") val title: String?,
    @field:SerializedName("poster_path") @Expose val posterPath: String?
)