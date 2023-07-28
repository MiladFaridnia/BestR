package com.faridnia.bestr.domain.model

data class GeocodedWaypoint(
    val geocoderStatus: String,
    val placeId: String,
    val types: List<String>
)
