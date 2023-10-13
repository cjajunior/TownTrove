package br.com.towntrove.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.towntrove.R
import br.com.towntrove.data.DataCafe
import br.com.towntrove.data.DataParque
import br.com.towntrove.data.DataRestaurante
import br.com.towntrove.data.LocalDataProvider
import br.com.towntrove.data.SharedViewModel
import br.com.towntrove.model.Coffee
import br.com.towntrove.model.Parque
import br.com.towntrove.model.Restaurante
import br.com.towntrove.ui.theme.Blue30

@Composable
fun Screentela(navController: NavController) {
    val dataCoffee = DataCafe.dataCoffee
    val images = dataCoffee.map { it.imageCoffe }

    Box(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        TelaPrincipal(name = "Junioor")
        CoffeeImageList(dataCoffee, navController)
        RestauranteImagens(dataRestaurante = DataRestaurante.dataRestaurante)
        ParquesImagens(dataParque = DataParque.dataParque)
    }
}

@Composable
fun CoffeeImageList(
    dataCoffee: List<Coffee>,
    navController: NavController
) {
    var currentIndex by remember { mutableStateOf(0) }
    val images = dataCoffee.map { it.imageCoffe }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(images.size) { index ->
            Spacer(modifier = Modifier.width(8.dp))
            CoffeeImage(images[index]) {
                currentIndex = index
//                if (currentIndex == 0) {
//                    navController.navigate(NavScreens.DetalhesCafe.route)
//                }
            }

        }
    }
}


@Composable
fun CoffeeImage(imageResId: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "Coffee Image",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .size(370.dp)
            .padding(top = 170.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
    )
}

@Composable
fun TelaPrincipal(name: String) {
//    Box(
//        modifier = Modifier.verticalScroll(rememberScrollState())
//    ) {
        Column(
            modifier = Modifier.padding(start = 20.dp, top = 35.dp)
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(94.dp)
                    .height(30.dp)
            ) {
                TextStyled(
                    text = "Hello, $name ",
                    style = TextStyle(
                        fontSize = 22.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF2E3E5C),
                        letterSpacing = 0.5.sp,
                    )
                )
            }
            Box(
                Modifier
                    .width(200.dp)
                    .height(190.dp)
            ) {
                TextStyled(
                    text = "Vamos Explorar com TownTrove!",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF2E3E5C),
                        letterSpacing = 0.5.sp,
                    )
                )
            }
        }
        Box(
            Modifier
                .padding(start = 20.dp, top = 126.dp)
        ) {
            TextStyled(
                text = "Novas Cafeterias",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
        }



        Box(
            modifier = Modifier
                .padding(start = 20.dp, top = 405.dp)
                .width(125.dp)
                .height(28.dp)

        ) {
            TextStyled(
                text = "Restaurantes",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 20.dp, top = 700.dp)
        ) {
            TextStyled(
                text = "Parques Populares",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )
            )
        }
    }



@Composable
fun TextStyled(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = style,
        modifier = modifier
    )
}

@Composable
fun RestauranteImagens(dataRestaurante: List<Restaurante>) {
    LazyRow(
        modifier = Modifier
            .padding(top = 450.dp, bottom = 50.dp)
    ) {
        items(dataRestaurante) { item ->
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = item.imageRestaurante),
                contentDescription = "Restaurante Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp)
                    .width(154.dp)
                    .height(240.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun ParquesImagens(dataParque: List<Parque>) {
    LazyRow(
        modifier = Modifier
            .padding(top = 750.dp, bottom = 50.dp)
    ) {
        items(dataParque) { item ->
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = item.imageParque),
                contentDescription = "Parques Image",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp)
                    .width(154.dp)
                    .height(240.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun ScaffoldTopBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(Blue30)
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (canNavigateBack) {
            IconButton(onClick = navigateUp) {
                Icon(
                    Icons.Rounded.Home,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        TextStyled(
            text = "Town Trove",
            style = TextStyle(
                color = Cyan,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 23.sp
            )
        )

        Image(
            painter = painterResource(id = R.drawable.emblema),
            contentDescription = null,
            modifier = Modifier
                .size(35.dp)
                .clip(shape = RoundedCornerShape(100.dp))
        )
    }
}
