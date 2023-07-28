package com.faridnia.bestr.data.remote

import com.faridnia.bestr.data.remote.dto.GoogleDirectionsApiResponseDto
import retrofit2.http.GET

interface GoogleDirectionsApi {

    //MOCK URL : https://run.mocky.io/v3/f7746bb2-83c0-40f3-87d9-11987dafe0b0
    @GET("/maps/api/directions/json")
    suspend fun getDirections(): GoogleDirectionsApiResponseDto

}