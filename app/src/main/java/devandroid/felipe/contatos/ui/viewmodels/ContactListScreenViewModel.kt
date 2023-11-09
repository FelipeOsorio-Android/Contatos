package devandroid.felipe.contatos.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import devandroid.felipe.contatos.dao.ContactDao
import devandroid.felipe.contatos.stateholders.ContactListScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContactListScreenViewModel: ViewModel() {

    private val contactDao by lazy { ContactDao() }

    private val _uiState: MutableStateFlow<ContactListScreenUiState> =
        MutableStateFlow(ContactListScreenUiState())

    val uiState get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            contactDao.getAllContacts().collect { contactList ->
                _uiState.value = _uiState.value.copy(
                    contactList = contactList
                )
            }
        }
    }
}