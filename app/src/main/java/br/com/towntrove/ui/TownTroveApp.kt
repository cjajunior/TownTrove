package br.com.towntrove.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.towntrove.R
import br.com.towntrove.data.LocalDataProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    var text: String by remember {
        mutableStateOf("")
    }
    var isErrorVisible by remember { mutableStateOf(false) }

    NavHost(
        navController = navController,
        startDestination = navScreens.Detalhes.route
    ) {
        composable(navScreens.Detalhes.route) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.fundo2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Text(
                    text = "TownTrove",
                    style = TextStyle(
                        fontSize = 35.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight(1000),
                        color = Color(0xFF2E3E5C),
                        letterSpacing = 0.80.sp,
                    ),
                    modifier = Modifier.padding(bottom = 230.dp)
                )
            }


            var isErrorVisible by remember { mutableStateOf(false) }

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 50.dp)
            ) {
                val textFieldColors = TextFieldDefaults.textFieldColors(
                    if (isErrorVisible) Color.Red else Color.Black
                )

                TextField(
                    value = text,
                    onValueChange = {
                        if (it.all { char -> !char.isDigit() }) {
                            text = it
                            isErrorVisible = false
                        } else {
                            isErrorVisible = true
                        }
                    },
                    visualTransformation = if (isErrorVisible) VisualTransformation.None else VisualTransformation.None,
                    colors = textFieldColors,
                    placeholder = { Text(text = "Digite seu nome") },
                    modifier = Modifier.fillMaxWidth()
                )

                if (isErrorVisible) {
                    Text(
                        text = "Não é permitido inserir números ou deixar em branco",
                        color = Color.Red
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        if (text.isNotEmpty() && !isErrorVisible) {
                            navController.navigate(navScreens.Home.route) {
                                // Limpa a pilha de navegação antes de ir para a tela principal
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                            }
                        } else {
                            isErrorVisible = true
                        }
                    }, modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "Próximo"
                    )
                }
            }
        }

        composable(navScreens.Home.route) {
            TownTroveHomeScreen(
                trove = LocalDataProvider.data.first()/* Seu trove aqui */,
                navController = navController
            )
        }
        composable(navScreens.principal.route) {
            TelaPrincipal(text)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, apiLevel = 30, device = "id:pixel_6")
fun PrincipalScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = { ScaffoldTopBar() },
        ) {
            Box(
                modifier = Modifier.padding(it)
            ) {
                TelaPrincipal("Junior")
            }
        }
    }
}
