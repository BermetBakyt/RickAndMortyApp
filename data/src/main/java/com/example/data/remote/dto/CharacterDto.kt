package com.example.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.models.Character
import com.google.gson.annotations.SerializedName

@Entity
class CharacterDto (
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("created")
    val created: String,
    )

fun CharacterDto.toCharacter() : Character {
    return Character(
        id,
        name,
        status,
        species,
        gender,
        created,
        image,
        location
    )
}

