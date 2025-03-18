package br.com.fiap.descartaaqui.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.descartaaqui.data.model.PontoDescarte
import br.com.fiap.descartaaqui.data.viewmodel.PontoDescarteViewModel

@Composable
fun PontoDescarteScreen(viewModel: PontoDescarteViewModel = viewModel()) {
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }

    // Coleta a lista de pontos como um Flow
    val pontos by viewModel.pontos.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        // Campo de Latitude
        OutlinedTextField(
            value = latitude,
            onValueChange = { latitude = it },
            label = { Text("Latitude") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de Longitude
        OutlinedTextField(
            value = longitude,
            onValueChange = { longitude = it },
            label = { Text("Longitude") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de Descrição
        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição do Ponto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Botão para salvar o ponto
        Button(
            onClick = {
                // Verifica se latitude e longitude são números válidos
                val latitudeDouble = latitude.toDoubleOrNull() ?: 0.0
                val longitudeDouble = longitude.toDoubleOrNull() ?: 0.0

                val ponto = PontoDescarte(
                    latitude = latitudeDouble,
                    longitude = longitudeDouble,
                    descricao = descricao
                )
                viewModel.inserirPonto(ponto)
                latitude = ""
                longitude = ""
                descricao = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar Ponto")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Exibição dos pontos cadastrados
        LazyColumn {
            items(pontos) { ponto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Latitude: ${ponto.latitude}", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "Longitude: ${ponto.longitude}", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "Descrição: ${ponto.descricao}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
