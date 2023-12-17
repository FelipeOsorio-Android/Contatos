package devandroid.felipe.contatos.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import devandroid.felipe.contatos.database.entities.ContactEntity
import devandroid.felipe.contatos.repository.ContatcRepository
import devandroid.felipe.contatos.sample.sampleImage
import devandroid.felipe.contatos.stateholders.AddContactFormScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddContactFormScreenViewModel(application: Application): AndroidViewModel(application) {


    private val myRepository = ContatcRepository(application)

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
                        "fieldName" -> {
                            _uiState.value = _uiState.value.copy(
                                name = newValue
                            )
                        }

                        "fieldPhone" -> {
                            _uiState.value = _uiState.value.copy(
                                phoneNumber = newValue
                            )
                        }
                    }
                    _uiState.value = _uiState.value.copy(
                        validateContact = _uiState.value.name.isNotEmpty()
                                && _uiState.value.phoneNumber.isNotEmpty()
                                && _uiState.value.phoneNumber.length == 9,
                        isError = _uiState.value.phoneNumber.length > 9
                    )
                },
                onClearField = { field ->
                    when(field) {
                        "fieldName" -> {
                            _uiState.value = _uiState.value.copy(
                                name = ""
                            )
                        }

                        "fieldPhone" -> {
                            _uiState.value = _uiState.value.copy(
                                phoneNumber = ""
                            )
                        }

                        "fieldUrl" -> {
                            _uiState.value = _uiState.value.copy(
                                textUrl = ""
                            )
                        }
                    }
                    _uiState.value = _uiState.value.copy(
                        validateContact = _uiState.value.name.isNotEmpty()
                                && _uiState.value.phoneNumber.isNotEmpty()
                                && _uiState.value.phoneNumber.length == 9
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
                }
            )
        }
    }

   suspend fun saveContact() {
        _uiState.value.run {
            val contact = ContactEntity(
                name = name,
                phoneNumber = phoneNumber,
                image = textUrl.ifEmpty { sampleImage }

            )

            myRepository.save(contact)
        }
    }
}