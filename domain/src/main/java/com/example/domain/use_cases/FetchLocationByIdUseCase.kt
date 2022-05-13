package com.example.domain.use_cases

import com.example.domain.repository.LocationRepository
import javax.inject.Inject

class FetchLocationByIdUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    operator fun invoke (id: Int) = repository.fetchLocation(id)
}