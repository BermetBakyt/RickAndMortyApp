package com.example.domain.repository

import com.example.domain.Either
import com.example.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun fetchCharacters(): Flow<Either<String, List<Character>>>

    fun fetchCharacter(id: Int) : Flow<Either<String, Character>>
}