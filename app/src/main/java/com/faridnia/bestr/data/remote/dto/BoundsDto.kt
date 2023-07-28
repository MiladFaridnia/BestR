package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class BoundsDto(
    @SerializedName("northeast")
    val northeastDto: NortheastDto? = null,
    @SerializedName("southwest")
    val southwestDto: SouthwestDto? = null
)