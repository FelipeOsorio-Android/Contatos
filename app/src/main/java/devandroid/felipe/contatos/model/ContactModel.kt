package devandroid.felipe.contatos.model

data class ContactModel(
    val name: String,
    val callNumber: String,
    val image: String? = null
)