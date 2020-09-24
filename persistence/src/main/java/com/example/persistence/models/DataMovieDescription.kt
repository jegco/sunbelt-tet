package com.example.persistence.models

data class DataMovieDescription(
    val adult: Boolean?,
    val backdropPath: String?, val dataBelongsToCollection: DataBelongsToCollection?,
    val budget: Int?,
    val dataGenres: List<DataGenre>?,
    val homepage: String?,
    val id: Int?,
    val imdbId: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val dataProductionCompanies: List<DataProductionCompany>?,
    val dataProductionCountries: List<DataProductionCountry>?,
    val releaseDate: String?,
    val revenue: Int?,
    val runtime: Int?,
    val dataSpokenLanguages: List<DataSpokenLanguage>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?,
    val videos: List<DataVideo?>?
) {
}