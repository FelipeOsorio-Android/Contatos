package devandroid.felipe.contatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import devandroid.felipe.contatos.ui.screens.AddContactFormScreen
import devandroid.felipe.contatos.ui.theme.ContatosTheme
import devandroid.felipe.contatos.ui.viewmodels.AddContactFormScreenViewModel

class ContactFormActivity : ComponentActivity() {

    private val viewModel by viewModels<AddContactFormScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddContactFormScreen(viewModel = viewModel)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ContactFormPreview() {
    ContatosTheme {
        Surface {
            AddContactFormScreen()
        }
    }
}