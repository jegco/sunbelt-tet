package com.example.persistence.models.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "production_company")
data class EntityProductionCompany(
    val name: String?,
    @PrimaryKey
    var id: Int,
    @ForeignKey(
        entity = EntityMovieDescription::class,
        parentColumns = ["id"],
        childColumns = ["id_movie"],
        onDelete = ForeignKey.CASCADE
    )
    @field:SerializedName("id_movie") var idMovie: Int = 0
)
