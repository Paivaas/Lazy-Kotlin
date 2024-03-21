package br.senai.sp.jandira.twd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.twd.ui.theme.TwdTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwdTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Image(
        painter = painterResource(id = R.drawable.wallpaper),
        contentDescription = "Wallpaper",
        contentScale = ContentScale.Crop
    )

    Surface(
        color = Color(0x88000000)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Buscar personagens",
                        color = Color.White
                    )
                },
                shape = RoundedCornerShape(12.dp),
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar",
                            tint = Color.White
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Personagens",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))



            LazyColumn {
                // for (i in 1 .. 10){ item { Text(text = "olaaaa") } }

                items(40) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(bottom = 8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xaaFFFFFF)),
                        border = BorderStroke(
                            width = 3.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF58544D),
                                    Color(0xFF3F3B34)
                                )
                            )
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Card(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(
                                        width = 90.dp,
                                        height = 90.dp
                                    ),
                                shape = CircleShape

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.maggie),
                                    contentDescription = "Maggie"
                                )
                            }
                            Column {
                                Text(
                                    text = "Maggie",
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "Maggie Greene é uma personagem fictícia da série de quadrinhos The Walking Dead, interpretada por Lauren Cohan na adaptação televisiva de mesmo nome. Na série de quadrinhos, Maggie se torna a mãe substituta de Sophia após o suicídio da mãe da menina, Carol.",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    lineHeight = 15.sp
                                )
                            }
                        }

                    }
                }

            }

        }
    }

}

// option control k
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TwdTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting()
        }
    }
}