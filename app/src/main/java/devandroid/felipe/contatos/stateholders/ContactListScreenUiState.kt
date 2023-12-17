package devandroid.felipe.contatos.stateholders

import devandroid.felipe.contatos.database.entities.ContactEntity

data class ContactListScreenUiState(
    val contactList: List<ContactEntity> = emptyList(),
    val allContacts: Int = 0
)