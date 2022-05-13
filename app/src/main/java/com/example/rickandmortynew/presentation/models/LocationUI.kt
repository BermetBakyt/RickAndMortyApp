package com.example.rickandmortynew.presentation.models

import com.example.domain.models.location.Location

class LocationUI (
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: MutableList<String>,
    val url: String,
    val created: String
)

fun Location.toLocationUI() = LocationUI(
    id,
    name,
    type,
    dimension,
    residents,
    url,
    created,
)