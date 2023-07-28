package com.faridnia.bestr.data.remote.dto


import com.faridnia.bestr.domain.model.Duration
import com.google.gson.annotations.SerializedName

data class DurationDto(
    @SerializedName("text")
    val text: String,
    @SerializedName("value")
    val value: Int
)

fun DurationDto.toDuration() = Duration(text = text, value = value)