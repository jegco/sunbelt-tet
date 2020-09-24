package com.example.persistence.utils

import com.example.domain.models.*
import com.example.persistence.models.*

fun DataMovieCollection.toListOfMovies(): List<Movie?>? = this.movies?.map { movie -> movie.toDomainEntity() };

fun DataMovie?.toDomainEntity(): Movie? = this?.run { Movie(this.id, this.title, this.posterPath) }

fun DataMovieDescription?.toDomainEntity() : MovieDescription? = this?.run {
    MovieDescription(
        this.adult,
        this.backdropPath,
        this.dataBelongsToCollection?.toDomainEntity(),
        this.budget,
        this.dataGenres?.map { dataGenre -> dataGenre.toDomainEntity() },
        this.homepage,
        this.id,
        this.imdbId,
        this.originalLanguage,
        this.originalTitle,
        this.overview,
        this.popularity,
        this.posterPath,
        this.dataProductionCompanies?.map { dataProductionCompany -> dataProductionCompany.toDomainEntity() },
        this.dataProductionCountries?.map { dataProductionCountry -> dataProductionCountry.toDomainEntity() },
        this.releaseDate,
        this.revenue,
        this.runtime,
        this.dataSpokenLanguages?.map { dataSpokenLanguage -> dataSpokenLanguage.toDomainEntity() },
        this.status,
        this.tagline,
        this.title,
        this.video,
        this.voteAverage,
        this.voteCount,
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

fun DataVideo?.toDomainEntity() : Video? = this?.run { Video(this.id, this.key, this.name) }