package com.example.rickandmortynew.presentation.models

import com.example.domain.models.character.SimpleLocation

data class SimpleLocationUI(
    val name: String,
    val url: String
)


fun SimpleLocation.toSimpleLocationUI() = SimpleLocationUI(
    name,
    url
)


