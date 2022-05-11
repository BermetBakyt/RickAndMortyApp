package com.example.domain.repository

import com.example.domain.Either
import com.example.domain.models.character.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun fetchCharacter(id: Int) : Flow<Either<String, Character>>
}