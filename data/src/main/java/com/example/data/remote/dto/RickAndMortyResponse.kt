package com.example.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T>(
    val prev: String,
    val next: String,
    @SerializedName("results")
    val data: MutableList<T>
)