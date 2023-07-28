package com.faridnia.bestr.data.remote.dto


import com.faridnia.bestr.domain.model.GoogleDirectionsApiResponse
import com.google.gson.annotations.SerializedName

data class GoogleDirectionsApiResponseDto(
    @SerializedName("geocoded_waypoints")
    val geocodedWaypointDtos: List<GeocodedWaypointDto>,
    @SerializedName("routes")
    val routeDtos: List<RouteDto>,
    @SerializedName("status")
    val status: String
)

fun GoogleDirectionsApiResponseDto.toGoogleDirectionsApiResponse(): GoogleDirectionsApiResponse {
    return GoogleDirectionsApiResponse(
        geocodedWaypoints = geocodedWaypointDtos.map {it.toGeocodedWaypoint()  },
        routes = routeDtos.map { it.toRoute() },
        status = status
    )
}

