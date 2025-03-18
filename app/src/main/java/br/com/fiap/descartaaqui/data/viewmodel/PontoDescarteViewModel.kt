package br.com.fiap.descartaaqui.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.descartaaqui.data.model.PontoDescarte
import br.com.fiap.descartaaqui.data.repository.PontoDescarteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PontoDescarteViewModel(private val repository: PontoDescarteRepository) : ViewModel() {

    // Função para inserir um ponto
    fun inserirPonto(ponto: PontoDescarte) {
        viewModelScope.launch {
            repository.inserirPonto(ponto)
        }
    }

    // Função para listar os pontos, diretamente exposta como um Flow
    val pontos: Flow<List<PontoDescarte>> = repository.pontos
}
