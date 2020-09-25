package com.example.persistence.models

import com.google.gson.annotations.SerializedName

data class DataMovieCollection
    (@SerializedName("results") val movies: List<DataMovie>)