package com.example.dogyears

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appstres.R
import com.example.dogyears.ui.theme.DogYearsTheme
import com.example.appstres.components.MainIconButton

val SkyBlue = Color(0xFF87CEEB)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogAgeCalculatorScreen(navController: NavController?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calculadora de Edad Perruna", color = Color.White) }, // Título ajustado
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = SkyBlue
                ),
                navigationIcon = {
                    if (navController != null) {
                        MainIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) {
                            navController.popBackStack()
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        PosicionPantalla(paddingValues = paddingValues)
    }
}

@Composable
private fun PosicionPantalla(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var edad by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("") }

        val imagen: Painter = painterResource(id = R.drawable.a_os)

        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Crop, // Ajuste para que la imagen no ocupe todo el alto
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp) // Altura ajustada para evitar que ocupe demasiado espacio
        )

        Text(
            text = "Mis Años Perrunos",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )

        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Mi edad humana") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp) // Espaciado vertical agregado
        )

        ElevatedButton(
            onClick = {
                val edadInt = edad.toIntOrNull() ?: 0
                resultado = (edadInt * 7).toString()
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .width(200.dp), // Ancho ajustado para que el botón no sea tan ancho
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = SkyBlue,
                contentColor = Color.Black
            )
        ) {
            Text("Calcular Edad")
        }

        OutlinedTextField(
            value = resultado,
            readOnly = true,
            onValueChange = {},
            label = { Text("Edad Perruna") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp) // Espaciado agregado entre el resultado y los otros componentes
        )

        ElevatedButton(
            onClick = {
                resultado = ""
                edad = ""
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .width(200.dp), // Ancho ajustado para que el botón no sea tan ancho
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = SkyBlue,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Borrar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DogYearsTheme {
        DogAgeCalculatorScreen(navController = null)
    }
}

