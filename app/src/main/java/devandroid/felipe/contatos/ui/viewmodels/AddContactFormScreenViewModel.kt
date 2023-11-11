package devandroid.felipe.contatos.ui.viewmodels

import androidx.lifecycle.ViewModel
import devandroid.felipe.contatos.stateholders.AddContactFormScreenUiState
import devandroid.felipe.contatos.ui.components.DialogEditImage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddContactFormScreenViewModel: ViewModel() {

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
                onDialogShow = {
                    DialogEditImage(
                        onDismissRequest = {
                            _uiState.value = _uiState.value.copy(
                                showDialog = false
                            )
                        },
                        onLoadImage = {
                            _uiState.value = _uiState.value.copy(
                                image = it,
                                showDialog = false
                            )
                        }
                    )
                }

            )
        }
    }
}