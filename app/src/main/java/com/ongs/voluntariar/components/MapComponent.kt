package com.ongs.voluntariar.components

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest
import com.google.android.libraries.places.api.net.PlacesClient
import kotlinx.coroutines.launch

@Composable
fun MapComponent() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    var hasLocationPermission by remember { mutableStateOf(false) }
    var currentLocation by remember { mutableStateOf(LatLng(0.0, 0.0)) }
    var searchQuery by remember { mutableStateOf("") }
    var markers by remember { mutableStateOf(listOf<MarkerState>()) }
    val scope = rememberCoroutineScope()
    val fusedLocationClient: FusedLocationProviderClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    val apiKey = "API_KEY"

    LaunchedEffect(Unit) {
        if (!Places.isInitialized()) {
            Places.initialize(context, apiKey)
        }
    }
    val placesClient: PlacesClient = Places.createClient(context)

    // Gerenciador de permissões
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        hasLocationPermission = permissions.values.all { it }
    }

    LaunchedEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                val locationPermission = ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
                if (locationPermission == PackageManager.PERMISSION_GRANTED) {
                    hasLocationPermission = true
                    // Obter localização atual
                    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                        location?.let {
                            currentLocation = LatLng(it.latitude, it.longitude)
                        }
                    }
                } else {
                    permissionLauncher.launch(
                        arrayOf(
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                    )
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
    }

    if (hasLocationPermission) {
        val cameraPositionState = rememberCameraPositionState()
        val properties by remember {
            mutableStateOf(
                MapProperties(
                    isMyLocationEnabled = true,
                    mapType = MapType.NORMAL
                )
            )
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Barra de pesquisa
            OutlinedTextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                    if (it.isNotEmpty()) {
                        scope.launch {
                            val placeFields = listOf(
                                Place.Field.ID,
                                Place.Field.NAME,
                                Place.Field.LAT_LNG,
                                Place.Field.ADDRESS
                            )
                            val request = FindCurrentPlaceRequest.newInstance(placeFields)
                            placesClient.findCurrentPlace(request).addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val places = task.result?.placeLikelihoods
                                    markers = places?.mapNotNull { placeLikelihood ->
                                        placeLikelihood.place.latLng?.let { latLng ->
                                            MarkerState(position = latLng)
                                        }
                                    } ?: emptyList()
                                }
                            }
                        }
                    } else {
                        markers = emptyList()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Buscar ONGs próximas...") },
                singleLine = true
            )

            // Mapa
            Box(modifier = Modifier.fillMaxSize()) {
                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    properties = properties,
                    cameraPositionState = cameraPositionState
                ) {
                    markers.forEach { markerState ->
                        Marker(
                            state = markerState
                        )
                    }
                }
            }
        }
    } else {
        // Mostrar um componente de UI solicitando permissão
    }
}
