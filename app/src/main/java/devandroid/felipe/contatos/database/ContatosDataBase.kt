package devandroid.felipe.contatos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import devandroid.felipe.contatos.database.dao.ContactDao
import devandroid.felipe.contatos.database.entities.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class ContatosDataBase : RoomDatabase() {
    abstract fun ContactDao(): ContactDao

    companion object {
        private lateinit var db: ContatosDataBase

        fun getDb(context: Context): ContatosDataBase {
            if (!::db.isInitialized) {
                db = Room.databaseBuilder(
                    context,
                    ContatosDataBase::class.java,
                    "ContatosDataBase"
                ).build()
            }

            return db
        }
    }
}