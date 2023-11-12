package devandroid.felipe.contatos.ui.viewmodels

import androidx.lifecycle.ViewModel
import devandroid.felipe.contatos.dao.ContactDao
import devandroid.felipe.contatos.model.ContactModel
import devandroid.felipe.contatos.sample.sampleImage
import devandroid.felipe.contatos.stateholders.AddContactFormScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddContactFormScreenViewModel: ViewModel() {

    private val contactDao by lazy { ContactDao() }

    private val _uiState: MutableStateFlow<AddContactFormScreenUiState> =
        MutableStateFlow(AddContactFormScreenUiState())

    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                showDialog = false,
                isShowDialog = {
                    _uiState.value = _uiState.value.copy(
                        showDialog = true
                    )
                },
                onDismissRequest = {
                    _uiState.value = _uiState.value.copy(
                        showDialog = false
                    )
                },
                onValueChangeDialog = {
                    _uiState.value = _uiState.value.copy(
                        textUrl = it
                    )
                    if (_uiState.value.textUrl.isNotEmpty()) {
                        _uiState.value = _uiState.value.copy(
                            isEnabledButtonDialog = true
                        )
                    } else {
                        _uiState.value = _uiState.value.copy(
                            isEnabledButtonDialog = false
                        )
                    }
                },
                onLoadImageDialog = {
                    _uiState.value = _uiState.value.copy(
                        showDialog = false
                    )
                },
                onValueChange = { field, newValue ->
                    when(field) {
                        "name" -> {
                            _uiState.value = _uiState.value.copy(
                                name = newValue
                            )
                        }

                        "phone" -> {
                            _uiState.value = _uiState.value.copy(
                                phoneNumber = newValue
                            )
                        }
                    }
                    _uiState.value = _uiState.value.copy(
                        validateContact = _uiState.value.name.isNotEmpty()
                                && _uiState.value.phoneNumber.isNotEmpty(),
                        isError = _uiState.value.phoneNumber.length > 9
                    )
                },
                onClearField = { field ->
                    when(field) {
                        "name" -> {
                            _uiState.value = _uiState.value.copy(
                                name = ""
                            )
                        }

                        "phone" -> {
                            _uiState.value = _uiState.value.copy(
                                phoneNumber = ""
                            )
                        }
                    }
                }
            )
        }
    }

    fun saveContact() {
        _uiState.value.run {
            val contact = ContactModel(
                name = name,
                phoneNumber = phoneNumber,
                image = textUrl.ifEmpty { sampleImage }

            )

            contactDao.saveContact(contact)
        }
    }
}