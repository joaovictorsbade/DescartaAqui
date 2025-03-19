package br.com.fiap.descartaaqui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.descartaaqui.R

@Composable
fun EscolhaLixoScreen(navController: NavController) {
    Box( // Usa Box para alinhar elementos corretamente
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp), // Evita sobreposição com a barra
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo no topo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo DescarteAqui",
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Título da tela
            Text(
                text = "Escolha um tipo de lixo para descartar",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de botões de lixo
            val tiposDeLixo = listOf("Plástico", "Vidro", "Papel", "Metal", "Orgânico", "Eletrônico")

            tiposDeLixo.forEach { tipo ->
                OutlinedButton(
                    onClick = { navController.navigate("mapa/$tipo") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF2ECC71)
                    ),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        brush = SolidColor(Color(0xFF2ECC71))
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null,
                        tint = Color(0xFF2ECC71),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = tipo, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Barra de navegação inferior FIXADA no rodapé
        BottomNavigationBar(navController, Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier.fillMaxWidth(), // Aplica o modificador recebido
        containerColor = Color.White
    ) {
        val iconSize = 24.dp // Tamanho fixo para os ícones

        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_descarte), contentDescription = "Descarte", modifier = Modifier.size(iconSize)) },
            label = { Text("Descarte") },
            selected = false,
            onClick = { navController.navigate("descarte") }
        )

        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ideia), contentDescription = "Dicas", modifier = Modifier.size(iconSize)) },
            label = { Text("Dicas") },
            selected = false,
            onClick = { navController.navigate("dicas") }
        )

        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.config), contentDescription = "Configurações", modifier = Modifier.size(iconSize)) },
            label = { Text("Configurações") },
            selected = false,
            onClick = { navController.navigate("configuracoes") }
        )
    }
}

// Classe para melhor organização dos itens da barra de navegação
data class NavigationItem(val route: String, val icon: Int, val label: String)

@Preview(showBackground = true)
@Composable
fun PreviewEscolhaLixoScreen() {
    val navController = rememberNavController()
    EscolhaLixoScreen(navController)
}
