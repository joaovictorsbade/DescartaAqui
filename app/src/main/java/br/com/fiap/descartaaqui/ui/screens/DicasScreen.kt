package br.com.fiap.descartaaqui.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import br.com.fiap.descartaaqui.R

@Composable
fun DicasScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp), // Evita sobreposição com a barra inferior
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo DescarteAqui",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Dicas",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "Melhores maneiras de descartar lixo",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF2ECC71)
            )

            Spacer(modifier = Modifier.height(16.dp))

            val dicas = listOf(
                "Vidro" to "Lave as embalagens de vidro e remova as tampas antes de descartar.",
                "Vidro Quebrado" to "Descarte vidro quebrado em um recipiente seguro. Nunca jogue diretamente na lixeira. Envolva os cacos em papel ou coloque-os em uma embalagem resistente para evitar acidentes.",
                "Resíduos Orgânicos" to "Separe os resíduos orgânicos (restos de comida) dos recicláveis para evitar contaminação.",
                "Papel" to "Recicle apenas papéis limpos e secos. Não inclua papelão sujo ou com restos de comida."
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                items(dicas) { (titulo, descricao) ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(2.dp, Color(0xFF2ECC71))
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = titulo,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = descricao,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }

        // ✅ Alinha a BottomNavigationBar ao final da tela corretamente
        BottomNavigationBar(
            navController = navController,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}
