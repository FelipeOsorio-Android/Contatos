package devandroid.felipe.contatos.ui.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import devandroid.felipe.contatos.stateholders.AddContactFormScreenUiState
import devandroid.felipe.contatos.ui.viewmodels.AddContactFormScreenViewModel


@Composable
fun AddContactFormScreen(uiState: AddContactFormScreenUiState = AddContactFormScreenUiState()) {

    val image = uiState.image
    val onLoadImage = uiState.onDialogShow
    val showDialog = uiState.showDialog
    val isShowDialog = uiState.isShowDialog

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Box(
            Modifier
                .height(300.dp)
                .width(300.dp)
        ) {

            Button(
                onClick = { isShowDialog() },
                Modifier
                    .align(BottomCenter)
                    .zIndex(1f)
                    .padding(18.dp),
                border = BorderStroke(width = 4.dp, color = Color.White),
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null
                )
            }

            if (showDialog) {
                onLoadImage()
            } else {
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    Modifier
                        .height(250.dp)
                        .width(250.dp)
                        .clip(shape = CircleShape)
                        .align(Center),
                    contentScale = ContentScale.Crop,
                )
            }
        }

        OutlinedTextField(
            value = "",
            onValueChange = {},
            Modifier
                .fillMaxWidth(),
            label = { Text(text = "Nome") },
            placeholder = { Text(text = "Nome do Contato") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            Modifier
                .fillMaxWidth(),
            label = { Text(text = "Telefone") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Call, contentDescription = null)
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            prefix = { Text(text = "+55 17 ") }
        )
        
        Button(
            onClick = { /*TODO*/ },
            Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(6.dp),
        ) {
            Text(text = "Salvar", fontSize = 16.sp)
        }
    }
}

@Composable
fun AddContactFormScreen(viewModel: AddContactFormScreenViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    AddContactFormScreen(uiState = uiState)
}

@Preview(showSystemUi = true)
@Composable
fun AddContactFormScreenPreview() {
    AddContactFormScreen(AddContactFormScreenUiState(image = "https://images.pexels.com/photos/7372338/pexels-photo-7372338.jpeg"))
}