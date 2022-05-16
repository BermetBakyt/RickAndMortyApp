package com.example.domain.use_cases

import com.example.domain.repository.EpisodeRepository
import javax.inject.Inject

class FetchEpisodeByIdUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {
    operator fun invoke(id: Int) = repository.fetchEpisode(id)
}