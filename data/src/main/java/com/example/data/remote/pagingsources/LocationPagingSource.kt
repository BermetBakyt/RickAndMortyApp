package com.example.data.remote.pagingsources

import com.example.data.remote.dto.location.LocationDto
import com.example.data.remote.dto.location.toLocation
import com.example.data.remote.pagingsources.base.BasePagingSource
import com.example.data.remote.services.LocationApiService
import com.example.domain.models.location.Location

class LocationPagingSource (
    private val service: LocationApiService
    ) : BasePagingSource<LocationDto, Location>(
    { service.fetchLocations(it) },
    { data -> data.map { it.toLocation() } }
    )
