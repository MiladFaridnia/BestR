package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Southwest(
    @SerializedName("lat")
    val lat: Double? = null,
    @SerializedName("lng")
    val lng: Double? = null
)