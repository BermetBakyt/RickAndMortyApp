package com.example.rickandmortynew.presentation.ui.fragments.episodes

import com.example.data.repository.EpisodeRepositoryImpl
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.toEpisodeUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val repository: EpisodeRepositoryImpl
) : BaseViewModel() {
    fun fetchEpisodes() = repository.fetchEpisodes().collectPagingRequest { it.toEpisodeUI() }
}