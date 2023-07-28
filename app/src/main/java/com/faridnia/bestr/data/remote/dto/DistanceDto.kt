package com.faridnia.bestr.data.remote.dto


import com.faridnia.bestr.domain.model.Distance
import com.google.gson.annotations.SerializedName

data class DistanceDto(
    @SerializedName("text")
    val text: String,
    @SerializedName("value")
    val value: Int
)

fun DistanceDto.toDistance() = Distance(text = text, value = value)