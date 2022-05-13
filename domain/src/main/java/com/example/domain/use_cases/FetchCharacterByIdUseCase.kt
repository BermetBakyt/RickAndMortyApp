package com.example.domain.use_cases

import com.example.domain.repository.CharacterRepository
import javax.inject.Inject

class FetchCharacterByIdUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    operator fun invoke(id: Int) = characterRepository.fetchCharacter(id)
}