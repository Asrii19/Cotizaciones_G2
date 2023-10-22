package com.example.firstaplication.ui.theme.common.Cotizaciones

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstaplication.ui.theme.FirstAplicationTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CotizacionesAprobadasScreen() {
    var isSearchVisible by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color(0xFF0C0C22)),
                title = {
                    Text(
                        text = "COTIZACIÓN",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,

                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { /* Acción del menú */ }
                    ) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null, tint = Color.White)
                    }
                },
                actions = {
                    if (isSearchVisible) {
                        BasicTextField(
                            value = searchText,
                            onValueChange = {
                                searchText = it
                                /* Realiza la búsqueda aquí usando el valor de searchText */
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Search
                            ),
                            keyboardActions = KeyboardActions(
                                onSearch = {
                                    /* Realiza la búsqueda aquí usando el valor de searchText */
                                }
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White) // Fondo blanco para la barra de búsqueda
                                .padding(16.dp)
                        )

                        IconButton(
                            onClick = {
                                isSearchVisible = false
                                searchText = "" // Limpia el texto de búsqueda
                            }
                        ) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "Cerrar búsqueda", tint = Color.Black)
                        }
                    } else {
                        IconButton(
                            onClick = { isSearchVisible = true }
                        ) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Buscar", tint = Color.White)
                        }
                    }
                }
            )
        },
        content = {
            // Cuerpo
            innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF000080)) // Fondo azul marino
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                // Tabs
                val tabs = listOf("Pendientes", "Aprobadas")
                var selectedTabIndex by remember { mutableStateOf(0) }

                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier.fillMaxWidth(),
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                        )
                    }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(text = title) },
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index }
                        )
                    }
                }

                // Lista de cotizaciones
                val cotizaciones = generateCotizaciones() // Reemplaza con tus datos reales de la base de datos

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    if (selectedTabIndex == 0) {
                        items(cotizaciones) { cotizacion ->
                            CotizacionCardPendiente(cotizacion = cotizacion)
                        }
                    } else {
                        items(cotizaciones) { cotizacion ->
                            CotizacionCardAprobada(cotizacion = cotizacion)
                        }
                    }
                }
            }
        },
        bottomBar = {
            Text(
                text = "© 2023 CONDOSA. Todos los derechos reservados",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0C0C22))  // Fondo azul noche
                    .padding(16.dp),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    )
}


@Composable
fun generateCotizaciones(): List<Cotizacion> {
    val cotizaciones = mutableListOf<Cotizacion>()

    for (i in 1..8) {
        cotizaciones.add(
            Cotizacion(
                codigo = "COD-00$i",
                nombre = "Apellido1 Apellido2 Nombre $i",
                zona = "Los Claveles",
                fecha = "202$i-10-22"
            )
        )
    }

    return cotizaciones
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAplicationTheme {
        CotizacionesAprobadasScreen()
    }
}



