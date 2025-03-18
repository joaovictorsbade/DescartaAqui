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
    var nome by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    val pontos by viewModel.pontos.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome do Ponto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = endereco,
            onValueChange = { endereco = it },
            label = { Text("Endereço") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                val ponto = PontoDescarte(nome = nome, endereco = endereco)
                viewModel.inserirPonto(ponto)
                nome = ""
                endereco = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar Ponto")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(pontos) { ponto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = ponto.nome, style = MaterialTheme.typography.titleMedium)
                        Text(text = ponto.endereco, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
