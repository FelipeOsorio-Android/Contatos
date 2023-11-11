package devandroid.felipe.contatos.stateholders

data class DialogEditImageUiState(
    val image: String? = null,
    val textUrl: String = "",
    val onValueChange: () -> Unit = {},
    val onLoadImage: () -> Unit = {},
    val onDismissRequest: () -> Boolean = { false }
)