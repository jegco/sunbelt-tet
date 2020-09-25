package com.example.persistence.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataMovie(
    @field:SerializedName("id") val id: Int?,
    @field:SerializedName("title") val title: String?,
    @field:SerializedName("poster_path") @Expose val posterPath: String?
)