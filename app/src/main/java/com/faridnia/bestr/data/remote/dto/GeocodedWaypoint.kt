package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GeocodedWaypoint(
    @SerializedName("geocoder_status")
    val geocoderStatus: String? = null,
    @SerializedName("place_id")
    val placeId: String? = null,
    @SerializedName("types")
    val types: List<String?>? = null
)