package com.example.data.remote.dto.character

import com.example.domain.models.character.SimpleLocation
import com.google.gson.annotations.SerializedName

class SimpleLocationDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("residents")
    val residents: MutableList<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
)

fun SimpleLocationDto.toSimpleLocation(): SimpleLocation {
    return SimpleLocation(
        name,
        url
    )
}