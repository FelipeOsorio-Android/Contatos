package devandroid.felipe.contatos.stateholders

data class AddContactFormScreenUiState(
    val name: String = "",
    val phoneNumber: String = "",
    val textUrl: String = "",
    val isError: Boolean = false,
    val isEnabledButtonDialog: Boolean = false,
    val showDialog: Boolean = false,
    val validateContact: Boolean = false,
    val isShowDialog: () -> Unit = {},
    val onClearField: (String) -> Unit = {},
    val onDismissRequest: () -> Unit = {},
    val onValueChangeDialog: (String) -> Unit = {},
    val onLoadImageDialog: () -> Unit = {},
    val onValueChange: (String, String) -> Unit = { _, _ -> }
)