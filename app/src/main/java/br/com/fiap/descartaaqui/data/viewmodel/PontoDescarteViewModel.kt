package br.com.fiap.descartaaqui.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.descartaaqui.data.model.PontoDescarte
import br.com.fiap.descartaaqui.data.repository.PontoDescarteRepository
import kotlinx.coroutines.launch

class PontoDescarteViewModel(private val repository: PontoDescarteRepository) : ViewModel() {

    fun inserirPonto(ponto: PontoDescarte) {
        viewModelScope.launch {
            repository.inserirPonto(ponto)
        }
    }

    fun listarPontos(callback: (List<PontoDescarte>) -> Unit) {
        viewModelScope.launch {
            val pontos = repository.listarPontos()
            callback(pontos)
        }
    }
}
