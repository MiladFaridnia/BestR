package com.faridnia.bestr.domain.use_case

import com.faridnia.bestr.domain.model.GoogleDirectionsApiResponse
import com.faridnia.bestr.domain.repository.GoogleDirectionsRepository
import com.faridnia.bestr.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GoogleDirectionsUseCase @Inject constructor(private val repository: GoogleDirectionsRepository) {

    operator fun invoke(
        start: String,
        destination: String,
        key: String
    ): Flow<Resource<GoogleDirectionsApiResponse>> {
        return repository.getDirections(start = start, destination = destination, key = key)
    }

}
