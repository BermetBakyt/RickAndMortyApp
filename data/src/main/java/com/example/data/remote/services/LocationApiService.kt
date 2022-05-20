package com.example.data.remote.services

import com.example.data.remote.dto.RickAndMortyResponse
import com.example.data.remote.dto.location.LocationDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApiService {

    @GET("location")
    suspend fun fetchLocations(
        @Query("page") page: Int = 0
    ): RickAndMortyResponse<LocationDto>

    @GET("location/{id}")
    suspend fun fetchLocation(
        @Path("id") id: Int
    ): LocationDto
}