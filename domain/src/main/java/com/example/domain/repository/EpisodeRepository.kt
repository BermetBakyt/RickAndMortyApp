package com.example.domain.repository

import com.example.domain.Either
import com.example.domain.models.episode.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {
    fun fetchEpisode(id: Int): Flow<Either<String, Episode>>
}