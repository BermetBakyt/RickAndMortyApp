package com.example.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CharacterPagingResponse<T>(
    val prev: Int?,
    val next: Int?,
    @SerializedName("results")
    val data: MutableList<T>
)