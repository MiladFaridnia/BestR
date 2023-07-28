package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PolylineDto(
    @SerializedName("points")
    val points: String? = null
)