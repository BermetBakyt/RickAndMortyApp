package com.example.rickandmortynew.presentation.ui.fragments.location

import com.example.data.repository.LocationRepositoryImpl
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.toLocationUI

class LocationsViewModel (
    private val locationRepository: LocationRepositoryImpl
) : BaseViewModel() {

    fun fetchLocations() = locationRepository.fetchLocations().collectPagingRequest { it.toLocationUI() }
}