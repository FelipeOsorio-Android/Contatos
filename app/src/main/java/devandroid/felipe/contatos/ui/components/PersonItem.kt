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
import devandroid.felipe.contatos.model.ContactModel

@Composable
fun PersonItem(contact: ContactModel) {
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
            Text(text = contact.callNumber)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonItemPreview() {
    PersonItem(
        ContactModel(
            name = "Felipe",
            callNumber = "17991904806",
            image = "https://images.pexels.com/photos/18945259/pexels-photo-18945259/free-photo-of-morena-ardente-queimadura-combustao.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        )
    )
}