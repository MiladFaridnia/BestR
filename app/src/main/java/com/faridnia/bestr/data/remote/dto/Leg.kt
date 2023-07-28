package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Leg(
    @SerializedName("distance")
    val distance: Distance? = Distance(),
    @SerializedName("duration")
    val duration: Duration? = Duration(),
    @SerializedName("end_address")
    val endAddress: String? = "",
    @SerializedName("end_location")
    val endLocation: EndLocation? = EndLocation(),
    @SerializedName("start_address")
    val startAddress: String? = "",
    @SerializedName("start_location")
    val startLocation: StartLocation? = StartLocation(),
    @SerializedName("steps")
    val steps: List<Step>? = listOf(),
    @SerializedName("traffic_speed_entry")
    val trafficSpeedEntry: List<Any>? = listOf(),
    @SerializedName("via_waypoint")
    val viaWaypoint: List<Any>? = listOf()
)