package devandroid.felipe.contatos.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import devandroid.felipe.contatos.repository.ContatcRepository
import devandroid.felipe.contatos.stateholders.ContactListScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContactListScreenViewModel(application: Application): AndroidViewModel(application) {


    private val myRepository = ContatcRepository(application)

    private val _uiState: MutableStateFlow<ContactListScreenUiState> =
        MutableStateFlow(ContactListScreenUiState())

    val uiState get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            myRepository.listContact.collect { listContact ->
                _uiState.value = _uiState.value.copy(
                    contactList = listContact,
                    allContacts = listContact.size
                )
            }
        }
    }
}