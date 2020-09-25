package com.example.persistence.utils

import com.example.domain.models.Movie
import com.example.domain.models.MovieDescription
import com.example.domain.models.Video
import com.example.persistence.models.DataMovie
import com.example.persistence.models.DataMovieDescription
import com.example.persistence.models.DataVideo
import com.example.persistence.models.db.EntityDescriptionWithJoins
import com.example.persistence.models.db.EntityMovie
import com.example.persistence.models.db.EntityVideo

fun DataMovie.toDomainEntity(): Movie = Movie(this.id, this.title, this.posterPath)

fun DataMovie.toDbEntity(): EntityMovie = EntityMovie(this.id, this.title, this.posterPath)

fun EntityMovie.toDomainEntity(): Movie = Movie(this.id, this.title, this.posterPath)

fun DataMovieDescription.toDomainEntity(): MovieDescription = this.run {
    MovieDescription(
        this.adult ?: false,
        this.belongsToCollection?.name ?: "",
        this.genres?.map { dataGenre -> dataGenre.name ?: "" } ?: ArrayList(),
        this.id,
        this.overview ?: "",
        IMAGE_API_BASE_URL + this.posterPath,
        this.productionCompanies?.map { dataProductionCompany -> dataProductionCompany.name ?: "" }
            ?: ArrayList(),
        this.productionCountries?.map { dataProductionCountry -> dataProductionCountry.name ?: "" }
            ?: ArrayList(),
        this.releaseDate ?: "",
        this.spokenLanguages?.map { dataSpokenLanguage -> dataSpokenLanguage.iso_639_1 ?: "" }
            ?: ArrayList(),
        this.title ?: "",
        this.video ?: false,
        this.voteAverage ?: Double.MIN_VALUE,
        this.voteCount ?: 0,
        this.videos?.map { video -> video.toDomainEntity() }
    )
}

fun EntityDescriptionWithJoins.toDomainEntity(): MovieDescription = this.run {
    MovieDescription(
        this.description.adult ?: false,
        this.belongsToCollection?.name ?: "",
        this.genres?.map { dataGenre -> dataGenre.name ?: "" } ?: ArrayList(),
        this.description.id,
        this.description.overview ?: "",
        IMAGE_API_BASE_URL + this.description.posterPath,
        this.productionCompanies?.map { dataProductionCompany -> dataProductionCompany.name ?: "" }
            ?: ArrayList(),
        this.productionCountries?.map { dataProductionCountry -> dataProductionCountry.name ?: "" }
            ?: ArrayList(),
        this.description.releaseDate ?: "",
        this.spokenLanguages?.map { dataSpokenLanguage -> dataSpokenLanguage.language ?: "" }
            ?: ArrayList(),
        this.description.title ?: "",
        this.description.video ?: false,
        this.description.voteAverage ?: Double.MIN_VALUE,
        this.description.voteCount ?: 0,
        this.videos?.map { video -> video.toDomainEntity() }
    )
}

fun DataVideo?.toDomainEntity(): Video? = this?.run { Video(this.id, this.key, this.name) }

fun EntityVideo?.toDomainEntity(): Video? =
    this?.run { Video(this.id.toString(), this.key, this.name) }