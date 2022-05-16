package com.example.data.remote.dto.character

import com.example.domain.models.character.Origin
import com.google.gson.annotations.SerializedName

class OriginDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

fun OriginDto.toOrigin(): Origin {
    return Origin(
        name, url
    )
}