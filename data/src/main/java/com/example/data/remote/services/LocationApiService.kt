package com.example.data.remote.services

import com.example.data.remote.dto.CharacterPagingResponse
import com.example.data.remote.dto.RickAndMortyResponse
import com.example.data.remote.dto.location.LocationDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {

    @GET("/api/location")
    suspend fun fetchLocations(i: Int): Response<CharacterPagingResponse<LocationDto>>

    @GET("api/location/{id}")
    suspend fun fetchLocation(
        @Path("id") id: Int
    ): LocationDto
}