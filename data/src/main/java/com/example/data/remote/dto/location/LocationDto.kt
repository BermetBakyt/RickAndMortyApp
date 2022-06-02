package com.example.data.remote.dto.location

import com.example.domain.models.character.SimpleLocation
import com.example.domain.models.location.Location
import com.google.gson.annotations.SerializedName

class LocationDto (
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

fun LocationDto.toLocation(): Location {
    return Location(
        id,
        name,
        type,
        dimension,
        residents,
        url,
        created
    )
}