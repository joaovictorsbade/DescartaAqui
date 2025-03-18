package br.com.fiap.descartaaqui.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.descartaaqui.data.dao.PontoDescarteDao
import br.com.fiap.descartaaqui.data.model.PontoDescarte

@Database(entities = [PontoDescarte::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pontoDescarteDao(): PontoDescarteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "ponto_descarte_db"
                )
                    .fallbackToDestructiveMigration() // Permite recriação do banco em caso de mudança na versão
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
