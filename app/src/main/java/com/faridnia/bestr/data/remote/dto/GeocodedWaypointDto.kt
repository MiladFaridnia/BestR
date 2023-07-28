package com.faridnia.bestr.data.remote.dto


import com.faridnia.bestr.domain.model.GeocodedWaypoint
import com.google.gson.annotations.SerializedName

data class GeocodedWaypointDto(
    @SerializedName("geocoder_status")
    val geocoderStatus: String,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("types")
    val types: List<String>
)

fun GeocodedWaypointDto.toGeocodedWaypoint(): GeocodedWaypoint {
    return GeocodedWaypoint(
        geocoderStatus = geocoderStatus,
        placeId = placeId,
        types = types)
}