package devandroid.felipe.contatos.repository

import android.content.Context
import devandroid.felipe.contatos.database.ContatosDataBase
import devandroid.felipe.contatos.database.entities.ContactEntity
import kotlinx.coroutines.flow.Flow

class ContatcRepository(context: Context) {

    private val dataBase = ContatosDataBase.getDb(context).ContactDao()
    val listContact: Flow<List<ContactEntity>> = dataBase.getAll()

    suspend fun save(contact: ContactEntity) {
        dataBase.save(contact)
    }
}