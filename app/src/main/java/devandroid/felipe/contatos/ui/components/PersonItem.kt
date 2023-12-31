package devandroid.felipe.contatos.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import devandroid.felipe.contatos.database.entities.ContactEntity

@Composable
fun PersonItem(contact: ContactEntity) {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = contact.image,
            contentDescription = null,
            Modifier
                .height(40.dp)
                .width(40.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )

        Column(
            Modifier
                .padding(start = 16.dp)
        ) {
            Text(text = contact.name)
            Text(text = contact.phoneNumber)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonItemPreview() {
    PersonItem(
        ContactEntity(
            name = "Felipe",
            phoneNumber = "17991904806",
        )
    )
}