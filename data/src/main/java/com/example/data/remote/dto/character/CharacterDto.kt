package com.example.data.remote.dto.character

import com.example.domain.models.character.Character
import com.example.domain.models.character.SimpleLocation
import com.google.gson.annotations.SerializedName

class CharacterDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: OriginDto,
    @SerializedName("location")
    val location: SimpleLocationDto,
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episode: MutableList<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String,
)

fun CharacterDto.toCharacter(): Character {
    return Character(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin.toOrigin(),
        location.toSimpleLocation(),
        image,
        episode,
        url,
        created
    )
}

