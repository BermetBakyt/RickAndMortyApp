package com.example.rickandmortynew.presentation.models

import com.example.domain.models.character.Character
import com.example.domain.models.character.Origin
import com.example.domain.models.character.SimpleLocation
import com.example.rickandmortynew.presentation.base.IBaseDiffModel

data class CharacterUI(
    override val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginUI,
    val location: SimpleLocation,
    val image: String,
    val episode: MutableList<String>,
    val url: String,
    val created: String,

    var firstSeenIn: String = ""
) : IBaseDiffModel

fun Character.toCharacterUI() = CharacterUI(
    id,
    name,
    status,
    species,
    type,
    gender,
    origin.toOriginUI(),
    location,
    image,
    episode,
    url,
    created,
)