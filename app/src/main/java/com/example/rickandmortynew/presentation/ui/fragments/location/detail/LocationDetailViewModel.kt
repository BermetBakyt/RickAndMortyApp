package com.example.rickandmortynew.presentation.ui.fragments.location.detail

import com.example.domain.use_cases.FetchLocationByIdUseCase
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.LocationUI
import com.example.rickandmortynew.presentation.models.toLocationUI
import kotlinx.coroutines.flow.asStateFlow

class LocationDetailViewModel (
    private val fetchLocationByIdUseCase: FetchLocationByIdUseCase
) :BaseViewModel() {

    private val _locationDetailState = MutableUIStateFlow<LocationUI>()
    val episodeDetailState = _locationDetailState.asStateFlow()

    fun fetchLocationDetail(id: Int) {
        fetchLocationByIdUseCase(id).collectRequest(_locationDetailState) { it.toLocationUI() }
    }
}