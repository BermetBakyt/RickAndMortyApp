package com.example.rickandmortynew.presentation.models

import com.example.domain.models.character.Origin

class OriginUI (
    val name: String,
    val url: String,
)

fun Origin.toOriginUI() = OriginUI(
    name,
    url,
)