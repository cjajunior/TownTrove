package br.com.towntrove.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.towntrove.R
import br.com.towntrove.data.LocalDataProvider
import br.com.towntrove.model.Coffee
import br.com.towntrove.model.Trove
import br.com.towntrove.ui.theme.TownTroveTheme


@Composable
fun TownTroveHomeScreen(
    modifier: Modifier = Modifier,
    trove: Trove,
    navController: NavController
) {
    var currentIndex by remember { mutableStateOf(0) }
    var isImageClicked by remember { mutableStateOf(false) }
    val images = LocalDataProvider.data.map { it.imageDrawable }
    val titles = LocalDataProvider.data.map { stringResource(it.titleResourceId) }
    val descriptions = LocalDataProvider.data.map { stringResource(it.subtitleResourceId) }

    Image(
        painter = painterResource(images[currentIndex]),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(38.dp),
        contentAlignment = Alignment.Center
    ) {
        val offset = Offset(8.0f, 12.0f)
        Text(
            text = stringResource(R.string.app_name),
            style = TextStyle(
                fontSize = typography.displaySmall.fontSize,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = Color.Cyan,
                textAlign = TextAlign.Center,
                shadow = Shadow(
                    color = Color.Black, offset = offset, blurRadius = 3f
                )
            )
        )
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            val offset = Offset(5.0f, 12.0f)
            Text(
                text = titles[currentIndex],
                style = TextStyle(
                    fontSize = typography.headlineLarge.fontSize,
                    lineHeight = 26.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    shadow = Shadow(
                        color = if (currentIndex == 0 && !isImageClicked) Color.Magenta else if (currentIndex == 1) Color.Red else
                            Color.Cyan,
                        offset = offset, blurRadius = 5f
                    )
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.DarkGray.copy(alpha = 0.5f))
            ) {
                Text(
                    text = descriptions[currentIndex],
                    style = TextStyle(
                        fontSize = typography.titleLarge.fontSize,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(500)
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.icon1),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .size(120.dp)
                    .clickable(onClick = {
                        currentIndex++
                        if (currentIndex >= images.size) {
                            currentIndex = 0
                        }
                        if (currentIndex == 0) {
                            navController.navigate(NavScreens.Principal.route)
                        }
                    })
            )
        }
    }
}


@Composable
fun CafeDetalhes() {
    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Imagem do restaurante
        Image(
            painter = painterResource(id = R.drawable.cafetaria2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nome do restaurante
        Text(
            text = "teste",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        // Descrição do restaurante
        Text(
            text = "testeteteet",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Adicione um botão de retorno ou ação para voltar à lista de cafés.
        Button(onClick = { navController.previousBackStackEntry }) {
            Text(text = "Voltar")
        }
    }
}

@Preview
@Composable
fun DetalhesCoffeePreview() {
    Surface {
        CafeDetalhes()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, apiLevel = 30, device = "id:pixel_6")
@Composable
fun TownTrovePreviw() {
    TownTroveTheme {
        TownTroveApp()
    }
}
