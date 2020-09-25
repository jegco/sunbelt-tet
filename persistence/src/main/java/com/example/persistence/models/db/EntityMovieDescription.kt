package com.example.persistence.models.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_details")
data class EntityMovieDescription(
    @PrimaryKey @field:SerializedName("id") var id: Int,
    val adult: Boolean?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?,
) {
}