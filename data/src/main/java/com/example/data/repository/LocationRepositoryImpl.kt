package com.example.data.repository

import com.example.data.remote.dto.location.toLocation
import com.example.data.remote.pagingsources.CharacterPagingSource
import com.example.data.remote.pagingsources.LocationPagingSource
import com.example.data.remote.services.LocationApiService
import com.example.data.repository.base.BaseRepository
import com.example.domain.Either
import com.example.domain.models.location.Location
import com.example.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val service: LocationApiService
) : BaseRepository(), LocationRepository {

    fun fetchLocationsPaging() = doPagingRequest(LocationPagingSource(service))

    override fun fetchLocation(id: Int) = doRequest {
        service.fetchLocation(id).toLocation()
    }
}