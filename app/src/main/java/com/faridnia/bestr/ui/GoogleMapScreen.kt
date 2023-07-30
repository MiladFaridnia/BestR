package com.faridnia.bestr.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.faridnia.bestr.presentaion.GoogleDirectionsViewModel
import com.faridnia.bestr.util.Constants.KEY
import com.faridnia.bestr.util.Constants.TEHRAN
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun GoogleMapScreen(
    modifier: Modifier = Modifier,
    onMapLoaded: () -> Unit,
    viewModel: GoogleDirectionsViewModel
) {

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(TEHRAN, 12f)
    }

    val mapProperties by remember {
        mutableStateOf(MapProperties(mapType = MapType.NORMAL))
    }

    val uiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                compassEnabled = true,
                myLocationButtonEnabled = true
            )
        )
    }

    val googleMapOptions = GoogleMapOptions().camera(
        CameraPosition.fromLatLngZoom(
            TEHRAN,
            12f
        )
    )

    var markerPosition by remember { mutableStateOf<LatLng?>(null) }

    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState,
        properties = mapProperties,
        uiSettings = uiSettings,
        onMapLoaded = onMapLoaded,
        googleMapOptionsFactory = { googleMapOptions },
        onMapClick = { latLng ->
            markerPosition = latLng

            viewModel.getDirection(
                start = "${TEHRAN.latitude},${TEHRAN.longitude}",
                destination = "${latLng.latitude},${latLng.longitude}",
                KEY
            )
        }
    ) {
        if (markerPosition != null) {
            Marker(
                position = markerPosition!!,
                title = "Marker",
                snippet = "Marker ${markerPosition!!.latitude}, ${markerPosition!!.longitude}",
                onClick = {
                    Log.d("Milad", "marker clicked")
                    false
                },
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)
            )

            val pointList = viewModel.polyLinesPointState.value

            Polyline(
                points = pointList,
                onClick = {
                    Log.d("Milad", "${it.points} was clicked")
                })
        }
    }
}