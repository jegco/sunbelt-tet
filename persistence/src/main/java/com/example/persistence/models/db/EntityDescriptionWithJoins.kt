package com.example.persistence.models.db

import androidx.room.Embedded
import androidx.room.Relation
import com.google.gson.annotations.SerializedName

class EntityDescriptionWithJoins(
    @Embedded
    val description: EntityMovieDescription,
    @field:SerializedName("belongs_to_collection")
    @Relation(parentColumn = "id", entityColumn = "idMovie")
    val belongsToCollection: EntityBelongsToCollection?,
    @field:SerializedName("production_country")
    @Relation(parentColumn = "id", entityColumn = "idMovie")
    val productionCountries: List<EntityProductionCountry>?,
    @field:SerializedName("production_company")
    @Relation(parentColumn = "id", entityColumn = "idMovie")
    val productionCompanies: List<EntityProductionCompany>?,
    @field:SerializedName("genres")
    @Relation(parentColumn = "id", entityColumn = "idMovie")
    val genres: List<EntityGenre>?,
    @field:SerializedName("spoken_languages")
    @Relation(parentColumn = "id", entityColumn = "idMovie")
    val spokenLanguages: List<EntitySpokenLanguage>?,
    @field:SerializedName("videos")
    @Relation(parentColumn = "id", entityColumn = "idMovie")
    val videos: List<EntityVideo>?
)