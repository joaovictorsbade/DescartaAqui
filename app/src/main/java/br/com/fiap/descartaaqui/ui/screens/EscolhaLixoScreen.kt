package br.com.fiap.descartaaqui.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EscolhaLixoScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Escolha o tipo de lixo para descartar",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        val tiposDeLixo = listOf("Papel", "Plástico", "Vidro", "Metal", "Orgânico", "Eletrônico")

        tiposDeLixo.forEach { tipo ->
            Button(
                onClick = { navController.navigate("mapa/$tipo") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = tipo)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
