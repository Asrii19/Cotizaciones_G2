package com.example.firstaplication.ui.common.Solicitudes

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
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SolicitudesScreen(viewModel: SolicitudViewModel) {
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
                var selectedTabIndex by remember { mutableIntStateOf(0) }

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

                // Lista de solicitudes
                val solicitudes = viewModel.generateSolicitudesPendientes()

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    if (selectedTabIndex == 0) {
                        items(solicitudes) { s ->
                            CotizacionCardPendiente(solicitud = s,viewModel=viewModel)
                        }
                    } else {
                        items(solicitudes) { s ->
                            CotizacionCardPendiente(solicitud = s,viewModel=viewModel)
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



