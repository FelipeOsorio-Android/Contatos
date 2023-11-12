package devandroid.felipe.contatos.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import devandroid.felipe.contatos.R
import devandroid.felipe.contatos.stateholders.AddContactFormScreenUiState
import devandroid.felipe.contatos.ui.components.DialogLoadImage
import devandroid.felipe.contatos.ui.theme.Niagara
import devandroid.felipe.contatos.ui.viewmodels.AddContactFormScreenViewModel


@Composable
fun AddContactFormScreen(
    uiState: AddContactFormScreenUiState = AddContactFormScreenUiState(),
    onSaveClick: () -> Unit = {}
) {

    val name = uiState.name
    val phoneNumber = uiState.phoneNumber
    val textUrl = uiState.textUrl
    val isError = uiState.isError
    val showDialog = uiState.showDialog
    val isEnable = uiState.validateContact
    val isEnabledButtonDialog = uiState.isEnabledButtonDialog
    val onClearField = uiState.onClearField
    val isShowDialog = uiState.isShowDialog
    val onValueChange = uiState.onValueChange
    val onDismissRequest = uiState.onDismissRequest
    val onLoadImageDialog = uiState.onLoadImageDialog
    val onValueChangeDialog = uiState.onValueChangeDialog

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
            .padding(PaddingValues(vertical = 16.dp)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Box(
            Modifier
                .height(300.dp)
                .width(300.dp)
        ) {

            if (showDialog) {
                DialogLoadImage(
                    textUrl = textUrl,
                    isEnabledButtonDialog = isEnabledButtonDialog,
                    onDismissRequest = { onDismissRequest() },
                    onValueChangeDialog = { onValueChangeDialog(it) },
                    onLoadImageDialog = { onLoadImageDialog() }
                )
            } else {
                AsyncImage(
                    model = textUrl,
                    contentDescription = null,
                    Modifier
                        .height(250.dp)
                        .width(250.dp)
                        .clip(shape = CircleShape)
                        .align(Center),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    fallback = painterResource(id = R.drawable.placeholder),
                    error = painterResource(id = R.drawable.placeholder),

                )
            }

            IconButton(
                onClick = { isShowDialog() },
                colors = IconButtonDefaults.iconButtonColors(Niagara),
                modifier = Modifier
                    .align(BottomCenter)
                    .offset(y = (-20).dp)
                    .border(width = 4.dp, color = Color.White, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        OutlinedTextField(
            value = name,
            onValueChange = { onValueChange("name", it) },
            Modifier
                .fillMaxWidth(),
            label = { Text(text = "Nome") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Niagara,
                focusedLabelColor = Niagara,
                unfocusedContainerColor = Color.White,
            ),
            placeholder = { Text(text = "Nome do Contato") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = { onClearField("name") }
                ) {
                    if (name.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                capitalization = KeyboardCapitalization.Words
            )
        )

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { onValueChange("phone", it) },
            Modifier
                .fillMaxWidth(),
            label = { Text(text = "Telefone") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Niagara,
                focusedLabelColor = Niagara,
                unfocusedContainerColor = Color.White,
                errorContainerColor = Color.White
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = { onClearField("phone") }
                ) {
                    if (phoneNumber.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            prefix = { Text(text = "+55 17 ") },
            supportingText = {
                if(isError) {
                    Text(
                        text = "Numero Invalido",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            isError = isError
        )

        Button(
            onClick = { onSaveClick() },
            Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(Niagara),
            enabled = isEnable
        ) {
            Text(text = "Salvar", fontSize = 16.sp)
        }
    }
}

@Composable
fun AddContactFormScreen(viewModel: AddContactFormScreenViewModel, onSaveClick: () -> Unit) {
    val uiState by viewModel.uiState.collectAsState()

    AddContactFormScreen(uiState = uiState, onSaveClick = {
        viewModel.saveContact()
        onSaveClick()
    })
}

@Preview(showSystemUi = true)
@Composable
fun AddContactFormScreenPreview() {
    AddContactFormScreen()
}