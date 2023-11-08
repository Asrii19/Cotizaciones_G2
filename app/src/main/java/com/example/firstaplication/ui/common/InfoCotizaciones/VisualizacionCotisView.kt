package com.example.firstaplication.ui.theme.common.InfoCotizaciones

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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstaplication.ui.common.InfoCotizaciones.DetalleSolicitudViewModel
import com.example.firstaplication.ui.theme.FirstAplicationTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualizacionCotisScreen(viewModel: DetalleSolicitudViewModel, navController: NavController, idSolicitud: String?) {
    // Data de usuario
    val cotizacionObjeto = generateCotizaciones2() // Reemplaza con tus datos reales de la base de datos

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.height(60.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color(0xFF0C0C22)),
                title = {
                    Text(
                        text = idSolicitud.toString(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth().wrapContentSize(Alignment.Center)
                            .fillMaxHeight().wrapContentSize(Alignment.Center)
                    )
                },

                navigationIcon = {

                    IconButton(
                        onClick = {
                            navController.navigate("pantalla1")
                            viewModel.isLoading = true
                        },
                        modifier = Modifier.size(50.dp).fillMaxWidth().wrapContentSize(Alignment.Center)
                            .fillMaxHeight().wrapContentSize(Alignment.Center)
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Buscar", tint = Color.White
                            ,modifier = Modifier.size(48.dp)  // Aumenta el tamaño del icono
                        )
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
                if (!viewModel.isLoading) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        item{
                            Text(
                                text = "   Información PERSONAL",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )
                        }
                        item{
                            CotiCardVerDatosPersonal1(data = viewModel.dataDetalle)
                        }
                        item{
                            Text(
                                text = "   Información PREDIO",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )
                        }
                        item{
                            CotiCardVerDatosPredio2(data = viewModel.dataDetalle)
                        }
                        item{
                            Text(
                                text = "   Información SERVICIOS",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )
                        }
                        item{
                            CotiCardVerDatosServicios3(data = viewModel.dataDetalle)
                        }
                        item{
                            Text(
                                text = "   Información COTIZACIÓN",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )
                        }
                        item{
                            CotiCardVerDatosCotizacion4(data = viewModel.dataDetalle)
                        }
                    }
                }else {
                    CircularProgressIndicator(modifier = Modifier.fillMaxSize(), color = Color.Gray)
                    LaunchedEffect(Unit) {
                        if (idSolicitud != null) {
                            viewModel.cargarDataCotizada(idSolicitud)
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
fun generateCotizaciones2(): List<Cotizacion> {
    val cotizaciones = mutableListOf<Cotizacion>()
    cotizaciones.add(
        Cotizacion(_codigo="0000234",_nombre="patrick anastacio",_zona="Lima",_fecha="2023-10-23")
    )
    return cotizaciones
}





