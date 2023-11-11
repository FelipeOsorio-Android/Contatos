package devandroid.felipe.contatos.stateholders

import androidx.compose.runtime.Composable

data class AddContactFormScreenUiState(
    val name: String = "",
    val phoneNumber: String = "",
    val image: String? = null,
    val showDialog: Boolean = false,
    val isShowDialog: () -> Unit = {},
    val onDialogShow: @Composable () -> Unit = {}
)