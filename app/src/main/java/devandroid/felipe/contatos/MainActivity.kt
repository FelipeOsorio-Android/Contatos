package devandroid.felipe.contatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import devandroid.felipe.contatos.ui.screens.ContactListScreen
import devandroid.felipe.contatos.ui.theme.ContatosTheme
import devandroid.felipe.contatos.ui.theme.Green

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App {
                ContactListScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun App(content: @Composable () -> Unit) {
    ContatosTheme {
        Surface {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
            
            Scaffold(
                Modifier
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                topBar = {
                    TopAppBar(
                        title = {
                                Column(Modifier.padding(start = 16.dp)) {
                                    Text(
                                        text = "Contatos",
                                        fontSize = 16.sp,
                                        maxLines = 1
                                    )
                                    Text(
                                        text = "100 contatos",
                                        fontSize = 14.sp,
                                        maxLines = 1
                                    )
                                }
                        },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = Green,
                            titleContentColor = Color.White,
                            actionIconContentColor = Color.White,
                            navigationIconContentColor = Color.White
                        ),
                        navigationIcon = {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                        },
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null
                                )
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null
                                )
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_options),
                                    contentDescription = null,

                                )
                            }
                        },
                        scrollBehavior = scrollBehavior
                    )
                }
            ) {
                Box(modifier = Modifier.padding(it)){
                    content()
                }
            }
        }
    }
}