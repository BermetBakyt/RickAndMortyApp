package com.example.data.remote.pagingsources

import com.example.data.remote.dto.character.CharacterDto
import com.example.data.remote.dto.character.toCharacter
import com.example.data.remote.pagingsources.base.BasePagingSource
import com.example.data.remote.services.CharacterApiService
import com.example.domain.models.character.Character

class CharacterPagingSource(
    private val service: CharacterApiService
) : BasePagingSource<CharacterDto, Character>(
    { service.fetchCharacters(it) },
    { data -> data.map { it.toCharacter() } }
)