package com.example.persistence.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataMovieDescription(
    @SerializedName("adult") @Expose val adult: Boolean?,
    @SerializedName("belongs_to_collection") @Expose val belongsToCollection: DataBelongsToCollection?,
    @SerializedName("genres") @Expose val genres: List<DataGenre>?,
    @SerializedName("id") @Expose val id: Int?,
    @SerializedName("overview") @Expose val overview: String?,
    @SerializedName("poster_path") @Expose val posterPath: String?,
    @SerializedName("production_companies") @Expose val productionCompanies: List<DataProductionCompany>?,
    @SerializedName("production_countries") @Expose val productionCountries: List<DataProductionCountry>?,
    @SerializedName("release_date") @Expose val releaseDate: String?,
    @SerializedName("spoken_languages") @Expose val spokenLanguages: List<DataSpokenLanguage>?,
    @SerializedName("title") @Expose val title: String?,
    @SerializedName("video") @Expose val video: Boolean?,
    @SerializedName("vote_average") @Expose val voteAverage: Double?,
    @SerializedName("vote_count") @Expose val voteCount: Int?,
    @SerializedName("videos") @Expose val videos: List<DataVideo?>?
)