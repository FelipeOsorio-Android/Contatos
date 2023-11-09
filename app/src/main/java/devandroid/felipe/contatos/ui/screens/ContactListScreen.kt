package devandroid.felipe.contatos.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import devandroid.felipe.contatos.stateholders.ContactListScreenUiState
import devandroid.felipe.contatos.ui.components.AdditionalItem
import devandroid.felipe.contatos.ui.components.PersonItem
import devandroid.felipe.contatos.ui.theme.ContatosTheme
import devandroid.felipe.contatos.ui.viewmodels.ContactListScreenViewModel

@Composable
fun ContactListScreen(
    uiState: ContactListScreenUiState = ContactListScreenUiState(),
    onClick: () -> Unit = {}
) {

    val contactList = uiState.contactList

    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            AdditionalItem(icon = Icons.Default.Group, title = "Novo Grupo")
        }
        item {
            AdditionalItem(
                icon = Icons.Default.PersonAdd,
                title = "Novo Contato",
                onClick = onClick
            )
        }
        item {
            AdditionalItem(icon = Icons.Default.Groups, title = "Nova Comunidade")
        }
        item {
            Text(text = "Encontrar", fontSize = 14.sp)
        }
        item {
            AdditionalItem(icon = Icons.Default.Store, title = "Empresas")
        }
        item {
            Text(text = "Contatos no WhatsApp", fontSize = 14.sp)
        }
        items(contactList) {
            PersonItem(contact = it)
        }
    }
}
@Composable
fun ContactListScreen(viewModel: ContactListScreenViewModel, onClick: () -> Unit = {}) {
    val uiState by viewModel.uiState.collectAsState()

    ContactListScreen(uiState = uiState, onClick = onClick)
}

@Preview(showSystemUi = true)
@Composable
fun ContactListScreenPreview() {
    ContatosTheme {
        Surface {
            ContactListScreen()
        }
    }
}