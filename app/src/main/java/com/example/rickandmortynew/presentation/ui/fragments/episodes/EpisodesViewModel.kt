package com.example.rickandmortynew.presentation.ui.fragments.episodes

import com.example.data.repository.EpisodeRepositoryImpl
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.toEpisodeUI
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(
    private val repository: EpisodeRepositoryImpl
) : BaseViewModel() {
    fun fetchEpisodes() = repository.fetchEpisodes().collectPagingRequest { it.toEpisodeUI() }
}