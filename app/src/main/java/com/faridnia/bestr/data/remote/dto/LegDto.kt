package com.faridnia.bestr.data.remote.dto


import com.faridnia.bestr.domain.model.Leg
import com.google.gson.annotations.SerializedName

data class LegDto(
    @SerializedName("distance")
    val distanceDto: DistanceDto,
    @SerializedName("duration")
    val durationDto: DurationDto,
    @SerializedName("end_address")
    val endAddress: String? = "",
    @SerializedName("end_location")
    val endLocationDto: EndLocationDto? = EndLocationDto(),
    @SerializedName("start_address")
    val startAddress: String? = "",
    @SerializedName("start_location")
    val startLocationDto: StartLocationDto? = StartLocationDto(),
    @SerializedName("steps")
    val steps: List<StepDto>? = listOf(),
    @SerializedName("traffic_speed_entry")
    val trafficSpeedEntry: List<Any>? = listOf(),
    @SerializedName("via_waypoint")
    val viaWaypoint: List<Any>? = listOf()
)

fun LegDto.toLeg() = Leg(
    distance = distanceDto.toDistance(),
    duration = durationDto.toDuration()
)