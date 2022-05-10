package com.example.data.remote.dto

import com.google.gson.annotations.SerializedName

class RickAndMortyResponse<T>(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<T>
)