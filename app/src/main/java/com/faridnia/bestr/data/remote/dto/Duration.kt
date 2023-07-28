package com.faridnia.bestr.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Duration(
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("value")
    val value: Int? = null
)