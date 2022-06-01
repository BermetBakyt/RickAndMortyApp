package com.example.domain.use_cases

import com.example.domain.repository.LocationRepository

class FetchLocationByIdUseCase (
    private val locationRepository: LocationRepository) {

    operator fun invoke(id: Int) = locationRepository.fetchLocation(id)
}