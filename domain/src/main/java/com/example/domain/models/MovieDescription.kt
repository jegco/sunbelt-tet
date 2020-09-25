package com.example.domain.models

data class MovieDescription(
    val adult: Boolean,
    val belongsToCollection: String,
    val genres: List<String>,
    val id: Int?,
    val overview: String,
    val posterPath: String,
    val productionCompanies: List<String>,
    val productionCountries: List<String>,
    val releaseDate: String,
    val spokenLanguages: List<String>,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val videos: List<Video?>?
) {
}