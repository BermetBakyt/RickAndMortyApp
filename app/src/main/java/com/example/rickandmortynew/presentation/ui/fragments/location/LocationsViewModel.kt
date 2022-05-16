package com.example.rickandmortynew.presentation.ui.fragments.location

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.data.repository.LocationRepositoryImpl
import com.example.rickandmortynew.presentation.base.BaseViewModel
import com.example.rickandmortynew.presentation.models.toCharacterUI
import com.example.rickandmortynew.presentation.models.toLocationUI
import javax.inject.Inject

class LocationsViewModel  @Inject constructor(
    private val repository: LocationRepositoryImpl
) : BaseViewModel() {
    fun fetchLocations() = repository.fetchLocations().collectPagingRequest { it.toLocationUI() }
}