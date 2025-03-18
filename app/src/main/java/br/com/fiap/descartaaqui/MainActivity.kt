package br.com.fiap.descartaaqui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.descartaaqui.ui.screens.PontoDescarteScreen
import br.com.fiap.descartaaqui.ui.theme.DescartaAquiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DescartaAquiTheme {
                // Chama o método de navegação
                PontoDescarteApp()
            }
        }
    }
}

@Composable
fun PontoDescarteApp() {
    val navController = rememberNavController()

    // Configura o NavHost para navegar entre as telas
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("ponto_descarte") {
            PontoDescarteScreen()
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Tela Inicial")
        Spacer(modifier = Modifier.height(16.dp))

        // Botão para navegar até a tela de Ponto Descarte
        Button(
            onClick = { navController.navigate("ponto_descarte") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir para Ponto de Descarte")
        }
    }
}
