package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Step(
    @SerializedName("distance")
    val distance: Distance? = Distance(),
    @SerializedName("duration")
    val duration: DurationX? = DurationX(),
    @SerializedName("end_location")
    val endLocation: EndLocationX? = EndLocationX(),
    @SerializedName("html_instructions")
    val htmlInstructions: String? = "",
    @SerializedName("maneuver")
    val maneuver: String? = "",
    @SerializedName("polyline")
    val polyline: Polyline? = Polyline(),
    @SerializedName("start_location")
    val startLocation: StartLocationX? = StartLocationX(),
    @SerializedName("travel_mode")
    val travelMode: String? = ""
)