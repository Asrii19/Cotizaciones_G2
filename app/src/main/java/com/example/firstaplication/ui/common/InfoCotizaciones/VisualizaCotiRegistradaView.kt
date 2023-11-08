package com.example.firstaplication.ui.theme.common.InfoCotizaciones

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstaplication.ui.common.InfoCotizaciones.DetalleSolicitudViewModel
import com.example.firstaplication.ui.common.Solicitudes.CotizacionCardAprobada
import com.example.firstaplication.ui.common.Solicitudes.CotizacionCardPendiente

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualizacionCotiRegistradaScreen(viewModel: DetalleSolicitudViewModel, navController: NavController, idSolicitud: String?) {
    // Data de usuario
    val cotizacionObjeto = generateCotizaciones3() // Reemplaza con tus datos reales de la base de datos

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
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                            .fillMaxHeight()
                            .wrapContentSize(Alignment.Center)
                    )
                },
            )
        },

        //CUERPO
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
                            viewModel.cargarDataPendiente(idSolicitud)
                        }
                    }
                }


            }
        },

        //INFERIOR
        bottomBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Button(
                        onClick = {
                            navController.navigate("VisualizaracionSolicitudCotizada")
                            viewModel.isLoading = true
                        },
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(end = 10.dp)
                    ) {
                        Text(text = "REGISTRAR")
                    }
                    Button(
                        onClick = {
                            navController.navigate("pantalla1")
                            viewModel.isLoading = true
                                  },
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(end = 10.dp)
                    ) {
                        Text(text = "CANCELAR")
                    }
                }

        }
    )
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun generateCotizaciones3(): List<Cotizacion> {
    val cotizaciones = mutableListOf<Cotizacion>()
        cotizaciones.add(
            Cotizacion(_codigo="0000234",_nombre="patrick anastacio",_zona="Lima",_fecha="2023-10-23")
        )

    return cotizaciones
}





