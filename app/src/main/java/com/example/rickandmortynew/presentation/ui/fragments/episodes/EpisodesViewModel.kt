package com.example.rickandmortynew.presentation.ui.fragments.episodes

import com.example.data.repository.EpisodeRepositoryImpl
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.toEpisodeUI

class EpisodesViewModel (
    private val episodeRepository: EpisodeRepositoryImpl
) : BaseViewModel() {
    fun fetchEpisodes() = episodeRepository.fetchEpisodes().collectPagingRequest { it.toEpisodeUI() }
}