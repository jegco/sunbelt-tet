package com.example.persistence.models.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "video")
data class EntityVideo(
    @PrimaryKey val id: Int,
    val key: String?,
    val name: String?,
    @ForeignKey(
        entity = EntityMovieDescription::class,
        parentColumns = ["id"],
        childColumns = ["id_movie"],
        onDelete = ForeignKey.CASCADE
    )
    @field:SerializedName("id_movie") var idMovie: Int = 0
)