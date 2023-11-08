package devandroid.felipe.contatos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import devandroid.felipe.contatos.ui.theme.Niagara

@Composable
fun AdditionalItem(icon: ImageVector, title: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
       Box(
           Modifier
               .clip(shape = CircleShape)
               .background(color = Niagara)
               .padding(8.dp)
       ) {
           Icon(
               imageVector = icon,
               contentDescription = null,
               tint = Color.White
           )
       }
        Text(
            text = title,
            Modifier
                .padding(start = 8.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight(500)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AdditionalItemPreview() {
    AdditionalItem(icon = Icons.Default.Group, title = "Teste")
}