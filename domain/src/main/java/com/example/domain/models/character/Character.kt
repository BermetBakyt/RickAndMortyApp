package com.example.domain.models.character

class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: SimpleLocation,
    val image: String,
    val episode: MutableList<String>,
    val url: String,
    val created: String,
    var firstSeenIn: String = ""
)
