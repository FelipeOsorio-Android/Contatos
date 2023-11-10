package devandroid.felipe.contatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import devandroid.felipe.contatos.ui.screens.AddContactFormScreen
import devandroid.felipe.contatos.ui.theme.ContatosTheme

class ContactFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddContactFormScreen()
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