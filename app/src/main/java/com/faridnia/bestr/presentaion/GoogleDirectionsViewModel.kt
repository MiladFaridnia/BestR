package com.faridnia.bestr.presentaion

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faridnia.bestr.domain.model.GoogleDirectionsApiResponse
import com.faridnia.bestr.domain.use_case.GoogleDirectionsUseCase
import com.faridnia.bestr.util.Resource
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GoogleDirectionsViewModel @Inject constructor(private val useCase: GoogleDirectionsUseCase) :
    ViewModel() {

    val polyLinesPointState = mutableStateOf<List<LatLng>>(emptyList())

    private val _directionsState = mutableStateOf(DirectionState())
    val directionsState: State<DirectionState> = _directionsState

    fun getDirection(
        start: String,
        destination: String,
        key: String
    ) {
        viewModelScope.launch {
            useCase(
                start,
                destination,
                key
            ).onEach { responseResource ->
                when (responseResource) {
                    is Resource.Success -> handleSuccess(responseResource.data)
                    is Resource.Error -> handleError(responseResource.message)
                    is Resource.Loading -> handleLoading(true)
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun handleSuccess(data: GoogleDirectionsApiResponse?) {
        Log.d("Milad", "Success" + data?.status)

        _directionsState.value = directionsState.value.copy(
            response = data,
            isLoading = false,
            error = null
        )

        val decodedPoints = data?.routes?.get(0)?.overviewPolyline?.points?.let {
            decodePolyLinePoints(it)
        }

        decodedPoints?.let {
            polyLinesPointState.value = it
        }
    }

    private fun handleError(message: String?) {
        Log.d("Milad", "Error$message")
    }

    private fun handleLoading(isLoading: Boolean) {

    }

    private fun decodePolyLinePoints(pointsString: String): List<LatLng> {
        val poly = ArrayList<LatLng>()
        var index = 0
        val len = pointsString.length
        var lat = 0
        var lng = 0

        while (index < len) {
            var b: Int
            var shift = 0
            var result = 0
            do {
                b = pointsString[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lat += dlat

            shift = 0
            result = 0
            do {
                b = pointsString[index++].code - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lng += dlng

            val p = LatLng(
                lat.toDouble() / 1E5,
                lng.toDouble() / 1E5
            )
            poly.add(p)
        }
        return poly
    }

    private fun boundBuilder(pathPoints: List<LatLng>): LatLngBounds {
        val bounds = LatLngBounds.builder()
        if (pathPoints.size > 1) {
            for (point in pathPoints) {
                bounds.include(point)
            }
        }
        return bounds.build()
    }

}