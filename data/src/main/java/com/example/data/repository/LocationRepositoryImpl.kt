package com.example.data.repository

import com.example.data.remote.dto.location.toLocation
import com.example.data.remote.pagingsources.CharacterPagingSource
import com.example.data.remote.pagingsources.LocationPagingSource
import com.example.data.remote.services.LocationApiService
import com.example.data.repository.base.BaseRepository
import com.example.domain.repository.LocationRepository


class LocationRepositoryImpl (
    private val service: LocationApiService
) : BaseRepository(), LocationRepository {

    fun fetchLocations() = doPagingRequest(LocationPagingSource(service))

    override fun fetchLocation(id: Int) = doRequest {
        service.fetchLocation(id).toLocation()
    }
}