package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GoogleDirectionsApiResponseDto(
    @SerializedName("geocoded_waypoints")
    val geocodedWaypoints: List<GeocodedWaypoint>? = listOf(),
    @SerializedName("routes")
    val routes: List<Route>? = listOf(),
    @SerializedName("status")
    val status: String? = ""
)