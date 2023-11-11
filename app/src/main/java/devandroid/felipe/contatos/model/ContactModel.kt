package devandroid.felipe.contatos.model

data class ContactModel(
    val name: String,
    val phoneNumber: String,
    val image: String? = null
)