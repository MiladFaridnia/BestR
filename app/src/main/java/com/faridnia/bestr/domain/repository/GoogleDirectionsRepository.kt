package com.faridnia.bestr.domain.repository

import com.faridnia.bestr.domain.model.GoogleDirectionsApiResponse
import com.faridnia.bestr.util.Resource
import kotlinx.coroutines.flow.Flow

interface GoogleDirectionsRepository {

    fun getDirections(
        start: String,
        destination: String,
        key: String
    ): Flow<Resource<GoogleDirectionsApiResponse>>

}