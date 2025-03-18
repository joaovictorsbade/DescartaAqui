package br.com.fiap.descartaaqui.ui.viewmodel

import br.com.fiap.descartaaqui.data.dao.PontoDescarteDao
import br.com.fiap.descartaaqui.data.model.PontoDescarte
import kotlinx.coroutines.flow.Flow

class PontoDescarteRepository(private val dao: PontoDescarteDao) {

    // Agora o Flow é obtido diretamente do DAO
    val pontos: Flow<List<PontoDescarte>> = dao.listarTodos()

    // Função para inserir um ponto de descarte
    suspend fun inserirPonto(ponto: PontoDescarte) {
        dao.inserirPonto(ponto)
    }
}
