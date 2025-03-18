package br.com.fiap.descartaaqui.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.descartaaqui.data.model.PontoDescarte
import kotlinx.coroutines.flow.Flow

@Dao
interface PontoDescarteDao {
    @Insert
    suspend fun inserirPonto(ponto: PontoDescarte)

    @Query("SELECT * FROM pontos_descarte")
    fun listarTodos(): Flow<List<PontoDescarte>>  // Retorna Flow para reatividade
}

