package com.example.persistence.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataMovie(
    var id: Int? = null, var title: String? = null,
    @SerializedName("poster_path") @Expose var posterPath: String? = null
)