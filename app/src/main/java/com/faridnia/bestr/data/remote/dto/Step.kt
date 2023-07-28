package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class StepDto(
    @SerializedName("distance")
    val distanceDto: DistanceDto,
    @SerializedName("duration")
    val duration: DurationDto,
    @SerializedName("end_location")
    val endLocation: EndLocationDto? = EndLocationDto(),
    @SerializedName("html_instructions")
    val htmlInstructions: String? = "",
    @SerializedName("maneuver")
    val maneuver: String? = "",
    @SerializedName("polyline")
    val polylineDto: PolylineDto? = PolylineDto(),
    @SerializedName("start_location")
    val startLocation: StartLocationDto? = StartLocationDto(),
    @SerializedName("travel_mode")
    val travelMode: String? = ""
)