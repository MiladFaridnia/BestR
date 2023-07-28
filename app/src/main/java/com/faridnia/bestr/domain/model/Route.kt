package com.faridnia.bestr.domain.model

data class Route(
    val summary: String,
    val overviewPolyline: OverviewPolyline,
    val legs: List<Leg>
)
