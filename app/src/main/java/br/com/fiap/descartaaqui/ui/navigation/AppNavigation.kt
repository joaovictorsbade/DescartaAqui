package br.com.fiap.descartaaqui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.descartaaqui.ui.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("escolhaLixo") { EscolhaLixoScreen(navController) }
        composable("pontoDescarte") { PontoDescarteScreen() }
        composable("mapa/{tipoLixo}") { backStackEntry ->
            val tipoLixo = backStackEntry.arguments?.getString("tipoLixo") ?: "Desconhecido"
            MapaScreen(navController, tipoLixo)
        }
    }
}
