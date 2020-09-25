package com.example.persistence.models.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "belongs_to_collection")
data class EntityBelongsToCollection(
    @PrimaryKey var id: Int,
    val name: String?,
    @field:SerializedName("id_movie") val idMovie: Int = 0
)
