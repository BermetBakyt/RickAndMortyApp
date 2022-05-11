package com.example.domain.repository

import com.example.domain.Either
import com.example.domain.models.location.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun fetchLocation(id: Int): Flow<Either<String, Location>>
}