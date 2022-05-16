package com.example.rickandmortynew.presentation.models

import com.example.domain.models.location.Location
import com.example.rickandmortynew.presentation.base.IBaseDiffModel

data class LocationUI (
    override val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: MutableList<String>,
    val url: String,
    val created: String
) : IBaseDiffModel

fun Location.toLocationUI() = LocationUI(
    id,
    name,
    type,
    dimension,
    residents,
    url,
    created,
)