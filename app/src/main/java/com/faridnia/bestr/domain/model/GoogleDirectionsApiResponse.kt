package com.faridnia.bestr.domain.model

data class GoogleDirectionsApiResponse(
    val geocodedWaypoints: List<GeocodedWaypoint>,
    val routes: List<Route>,
    val status: String
)
