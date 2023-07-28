package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Bounds(
    @SerializedName("northeast")
    val northeast: Northeast? = null,
    @SerializedName("southwest")
    val southwest: Southwest? = null
)