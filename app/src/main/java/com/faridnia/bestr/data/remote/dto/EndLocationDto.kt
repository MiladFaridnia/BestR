package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class EndLocationDto(
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("lng")
    val lng: Double? = null
)