package com.example.persistence.models.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genre")
data class EntityGenre(
    @PrimaryKey val id: Int,
    val name: String?,
    @field:SerializedName("id_movie") var idMovie: Int = 0
)