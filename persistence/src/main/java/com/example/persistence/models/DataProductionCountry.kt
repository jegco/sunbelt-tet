package com.example.persistence.models

import androidx.room.ForeignKey
import com.example.persistence.models.db.EntityMovieDescription

data class DataProductionCountry(
    val iso31661: String?,
    val name: String?,
    @ForeignKey(
        entity = EntityMovieDescription::class,
        parentColumns = ["id"],
        childColumns = ["id_course"],
        onDelete = ForeignKey.CASCADE
    )
    private val id_course: Int = 0
)
