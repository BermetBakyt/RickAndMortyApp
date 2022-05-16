package com.example.data.remote.dto

data class CharacterPagingResponse<T>(
    val prev: Int?,
    val next: Int?,
    val data: MutableList<T>
)