package devandroid.felipe.contatos.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogEditImage(onDismissRequest: () -> Unit = {}) {

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            Modifier
                .fillMaxWidth()
                .height(400.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .clip(shape = CircleShape)
                ) {
                    AsyncImage(
                        model = "https://images.pexels.com/photos/18945259/pexels-photo-18945259/free-photo-of-morena-ardente-queimadura-combustao.jpeg",
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    Modifier
                        .fillMaxWidth(),
                    label = { Text(text = "URL") },
                    placeholder = { Text(text = "Url da Imagem/Foto") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Image, contentDescription = null)
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
                )

                Button(
                    onClick = { /*TODO*/ },
                    Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(text = "Carregar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogEditImagePreview() {
    DialogEditImage()
}