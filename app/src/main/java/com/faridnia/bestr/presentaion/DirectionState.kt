package com.faridnia.bestr.presentaion

import com.faridnia.bestr.domain.model.GoogleDirectionsApiResponse

data class DirectionState(
    val response: GoogleDirectionsApiResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
