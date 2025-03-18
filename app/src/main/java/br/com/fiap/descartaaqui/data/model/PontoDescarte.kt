package br.com.fiap.descartaaqui.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pontos_descarte")
data class PontoDescarte(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val latitude: Double,
    val longitude: Double,
    val descricao: String
)
