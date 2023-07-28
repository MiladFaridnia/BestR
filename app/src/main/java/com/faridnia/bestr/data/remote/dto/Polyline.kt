package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Polyline(
    @SerializedName("points")
    val points: String? = null
)