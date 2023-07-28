package com.faridnia.bestr.data.remote.dto


import com.faridnia.bestr.domain.model.OverviewPolyline
import com.google.gson.annotations.SerializedName

data class OverviewPolylineDto(
    @SerializedName("points")
    val points: String
)

fun OverviewPolylineDto.toOverviewPolyline(): OverviewPolyline {
    return OverviewPolyline(
        points = points
    )
}