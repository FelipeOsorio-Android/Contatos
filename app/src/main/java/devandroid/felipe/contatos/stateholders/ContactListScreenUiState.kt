package devandroid.felipe.contatos.stateholders

import devandroid.felipe.contatos.model.ContactModel

data class ContactListScreenUiState(
    val contactList: List<ContactModel> = emptyList(),
    val allContacts: Int = 0
)