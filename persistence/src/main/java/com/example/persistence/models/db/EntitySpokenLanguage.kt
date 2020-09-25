package com.example.persistence.models.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "spoken_language")
data class EntitySpokenLanguage(
    @PrimaryKey val iso_639_1: String,
    val language: String?,
    @field:SerializedName("id_movie") var idMovie: Int = 0
)