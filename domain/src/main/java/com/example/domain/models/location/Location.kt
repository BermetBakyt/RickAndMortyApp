package com.example.domain.models.location

class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: MutableList<String>,
    val url: String,
    val created: String
)