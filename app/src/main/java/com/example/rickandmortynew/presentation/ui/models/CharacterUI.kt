package com.example.rickandmortynew.presentation.ui.models

import com.example.domain.models.Character
import com.example.rickandmortynew.presentation.base.IBaseDiffModel

data class CharacterUI(
    override val id: Int,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val location: List<String>,
    val created: String,
    val image: String,
) : IBaseDiffModel

fun Character.toUI() = CharacterUI(
    id,
    name,
    species,
    status,
    gender,
    location,
    created,
    image
)