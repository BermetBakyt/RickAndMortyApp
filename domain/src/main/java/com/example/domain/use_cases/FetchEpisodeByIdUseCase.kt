package com.example.domain.use_cases

import com.example.domain.repository.EpisodeRepository

class FetchEpisodeByIdUseCase (
    private val episodeRepository: EpisodeRepository
) {
    operator fun invoke(id: Int) = episodeRepository.fetchEpisode(id)
}