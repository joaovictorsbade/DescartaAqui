package br.com.fiap.descartaaqui.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bem-vindo ao DescartaAqui!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Ajude o meio ambiente descartando seus resíduos corretamente. Comece agora!",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("escolhaLixo") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Começar")
        }
    }
}
