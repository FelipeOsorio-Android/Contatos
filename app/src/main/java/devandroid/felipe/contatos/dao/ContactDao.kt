package devandroid.felipe.contatos.dao

import devandroid.felipe.contatos.model.ContactModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContactDao {

    companion object {
        private val contactList = MutableStateFlow<List<ContactModel>>(emptyList())
    }

    fun getAllContacts(): StateFlow<List<ContactModel>> = contactList.asStateFlow()

    fun saveContact(contact: ContactModel) {
        contactList.value = contactList.value + contact
    }
}