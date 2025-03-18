package br.com.fiap.descartaaqui.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapaScreen(navController: NavController, tipoLixo: String) {
    val initialLocation = LatLng(-23.5505, -46.6333) // São Paulo como padrão
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialLocation, 12f)
    }

    val pontosDeDescarte = remember { mutableStateListOf<LatLng>() }

    LaunchedEffect(tipoLixo) {
        pontosDeDescarte.clear()
        pontosDeDescarte.addAll(buscarPontosDescarte(tipoLixo))
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        pontosDeDescarte.forEach { location ->
            Marker(
                state = rememberMarkerState(position = location),
                title = "Ponto de descarte de $tipoLixo"
            )
        }
    }
}

fun buscarPontosDescarte(tipoLixo: String): List<LatLng> {
    return when (tipoLixo) {
        "Papel" -> listOf(
            LatLng(-23.5560, -46.6350),
            LatLng(-23.5520, -46.6300)
        )
        "Plástico" -> listOf(
            LatLng(-23.5600, -46.6400),
            LatLng(-23.5500, -46.6200)
        )
        "Vidro" -> listOf(
            LatLng(-23.5450, -46.6250),
            LatLng(-23.5700, -46.6100)
        )
        else -> listOf(
            LatLng(-23.5505, -46.6333) // Local padrão se não encontrar
        )
    }
}
