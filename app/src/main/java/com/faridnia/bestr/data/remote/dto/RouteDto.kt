package com.faridnia.bestr.data.remote.dto


import com.faridnia.bestr.domain.model.Route
import com.google.gson.annotations.SerializedName

data class RouteDto(
    @SerializedName("bounds")
    val boundsDto: BoundsDto,
    @SerializedName("copyrights")
    val copyrights: String,
    @SerializedName("legs")
    val legs: List<LegDto>,
    @SerializedName("overview_polyline")
    val overviewPolylineDto: OverviewPolylineDto,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("warnings")
    val warnings: List<Any>? = listOf(),
    @SerializedName("waypoint_order")
    val waypointOrder: List<Int>
)

fun RouteDto.toRoute(): Route {
    return Route(
        summary = summary,
        overviewPolyline = overviewPolylineDto.toOverviewPolyline(),
        legs = legs.map { it.toLeg() }
    )
}