package com.example.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(
    val info: Info,
    @SerializedName("results")
    val data: MutableList<T>
)