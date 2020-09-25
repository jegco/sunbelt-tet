package com.example.persistence.utils

import com.example.domain.models.*
import com.example.persistence.models.*
import com.example.persistence.models.db.*

fun DataMovieCollection.toListOfMovies(): List<Movie> =
    this.movies.map { movie -> movie.toDomainEntity() };

fun DataMovie.toDomainEntity(): Movie = Movie(this.id, this.title, this.posterPath)

fun DataMovie.toDbEntity(): EntityMovie = EntityMovie(this.id, this.title, this.posterPath)

fun EntityMovie.toDomainEntity(): Movie = Movie(this.id, this.title, this.posterPath)

fun DataMovieDescription.toDomainEntity(): MovieDescription = this.run {
    MovieDescription(
        this.adult,
        this.backdropPath,
        this.belongsToCollection?.toDomainEntity(),
        this.budget,
        this.genres?.map { dataGenre -> dataGenre.toDomainEntity() },
        this.homepage,
        this.id,
        this.imdbId,
        this.originalLanguage,
        this.originalTitle,
        this.overview,
        popularity = this.popularity,
        posterPath = IMAGE_API_BASE_URL + this.posterPath,
        this.productionCompanies?.map { dataProductionCompany -> dataProductionCompany.toDomainEntity() },
        this.productionCountries?.map { dataProductionCountry -> dataProductionCountry.toDomainEntity() },
        this.releaseDate,
        this.revenue,
        this.runtime,
        this.spokenLanguages?.map { dataSpokenLanguage -> dataSpokenLanguage.toDomainEntity() },
        this.status,
        this.tagline,
        this.title,
        this.video,
        this.voteAverage,
        this.voteCount,
        this.videos?.map { video -> video.toDomainEntity() }
    )
}

fun EntityDescriptionWithJoins.toDomainEntity(): MovieDescription = this.run {
    MovieDescription(
        this.description.adult,
        this.description.backdropPath,
        this.belongsToCollection.toDomainEntity(),
        this.description.budget,
        this.genres?.map { dataGenre -> dataGenre.toDomainEntity() },
        this.description.homepage,
        this.description.id,
        this.description.imdbId,
        this.description.originalLanguage,
        this.description.originalTitle,
        this.description.overview,
        this.description.popularity,
        this.description.posterPath,
        this.productionCompanies?.map { dataProductionCompany -> dataProductionCompany.toDomainEntity() },
        this.productionCountries?.map { dataProductionCountry -> dataProductionCountry.toDomainEntity() },
        this.description.releaseDate,
        this.description.revenue,
        this.description.runtime,
        this.spokenLanguages?.map { dataSpokenLanguage -> dataSpokenLanguage.toDomainEntity() },
        this.description.status,
        this.description.tagline,
        this.description.title,
        this.description.video,
        this.description.voteAverage,
        this.description.voteCount,
        this.videos?.map { video -> video.toDomainEntity() }
    )
}

fun DataBelongsToCollection?.toDomainEntity(): BelongsToCollection? = this?.run {
    BelongsToCollection(this.id, this.name)
}

fun DataGenre?.toDomainEntity(): Genre? = this?.run { Genre(this.id, this.name) }

fun DataProductionCompany?.toDomainEntity(): ProductionCompany? = this?.run {
    ProductionCompany(this.name, this.id)
}

fun DataProductionCountry?.toDomainEntity(): ProductionCountry? = this?.run {
    ProductionCountry(this.iso31661, this.name)
}

fun DataSpokenLanguage?.toDomainEntity(): SpokenLanguage? = this?.run {
    SpokenLanguage(this.iso_639_1, this.language)
}

fun DataVideo?.toDomainEntity(): Video? = this?.run { Video(this.id, this.key, this.name) }

fun EntityBelongsToCollection?.toDomainEntity(): BelongsToCollection? = this?.run {
    BelongsToCollection(this.id, this.name)
}

fun EntityGenre?.toDomainEntity(): Genre? = this?.run { Genre(this.id, this.name) }

fun EntityProductionCompany?.toDomainEntity(): ProductionCompany? = this?.run {
    ProductionCompany(this.name, this.id)
}

fun EntityProductionCountry?.toDomainEntity(): ProductionCountry? = this?.run {
    ProductionCountry(this.iso31661, this.name)
}

fun EntitySpokenLanguage?.toDomainEntity(): SpokenLanguage? = this?.run {
    SpokenLanguage(this.iso_639_1, this.language)
}

fun EntityVideo?.toDomainEntity(): Video? = this?.run { Video(this.id.toString(), this.key, this.name) }