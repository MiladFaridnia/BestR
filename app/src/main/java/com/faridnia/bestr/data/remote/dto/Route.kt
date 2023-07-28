package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Route(
    @SerializedName("bounds")
    val bounds: Bounds? = Bounds(),
    @SerializedName("copyrights")
    val copyrights: String? = "",
    @SerializedName("legs")
    val legs: List<Leg>? = listOf(),
    @SerializedName("overview_polyline")
    val overviewPolyline: OverviewPolyline? = OverviewPolyline(),
    @SerializedName("summary")
    val summary: String? = "",
    @SerializedName("warnings")
    val warnings: List<Any>? = listOf(),
    @SerializedName("waypoint_order")
    val waypointOrder: List<Int>? = listOf()
)