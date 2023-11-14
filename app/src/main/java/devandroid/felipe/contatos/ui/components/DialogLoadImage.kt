package devandroid.felipe.contatos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import devandroid.felipe.contatos.R
import devandroid.felipe.contatos.ui.theme.Niagara


@Composable
fun DialogLoadImage(
    textUrl: String = "",
    isEnabledButtonDialog: Boolean = false,
    onLoadImageDialog: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
    onClearField:(String) -> Unit = {},
    onValueChangeDialog: (String) -> Unit = {}
) {


    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            Modifier
                .fillMaxWidth()
                .height(400.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
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
                        model = textUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(id = R.drawable.placeholder),
                        fallback = painterResource(id = R.drawable.placeholder),
                        error = painterResource(id = R.drawable.placeholder)
                    )
                }

                OutlinedTextField(
                    value = textUrl,
                    onValueChange = { onValueChangeDialog(it) },
                    Modifier
                        .fillMaxWidth(),
                    label = { Text(text = stringResource(id = R.string.url)) },
                    placeholder = { Text(text = stringResource(R.string.url)) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Image, contentDescription = null)
                    },
                    trailingIcon = {
                        IconButton(onClick = { onClearField("fieldUrl") }) {
                            if(textUrl.isNotEmpty()) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = null
                                )
                            }
                        }
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = Niagara,
                        focusedIndicatorColor = Niagara,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                Button(
                    onClick = { onLoadImageDialog() },
                    Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Niagara
                    ),
                    enabled = isEnabledButtonDialog
                ) {
                    Text(text = stringResource(R.string.load))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogLoadImagePreview() {
    DialogLoadImage()
}