package com.example.firstaplication.ui.views.Solicitudes

import androidx.compose.material.icons.filled.Email
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstaplication.ui.views.infoSolicitudes.DetalleSolicitudViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualizacionSolicitudCotizadaScreen(viewModel: DetalleSolicitudViewModel, navController: NavController,idSolicitud: String?) {
    viewModel.isLoading = true
    Scaffold(
        contentColor = Color(0xFF000080),
        containerColor = Color(0xFF000080),
        topBar = {
            TopAppBar(
                modifier = Modifier.height(60.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color(0xFF000080)),
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
            )
        },

        //CUERPO

        content = { innerPadding ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding) // Para centrar horizontalmente
                        .background(Color.LightGray), // Fondo plomo claro
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        if (!viewModel.isLoading){

                        Text(
                            text = "COTIZACIÓN REALIZADA CON ÉXITO",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("Información de la cotización:", modifier = Modifier)

                        Text("Predio: ${viewModel.dataDetalle.nombre_predio}", modifier = Modifier)
                        Text("Tipo: ${viewModel.dataDetalle.tipo_predio}", modifier = Modifier)
                        Text("Cliente: ${viewModel.dataDetalle.nombre}", modifier = Modifier)

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "TOTAL COTIZADO:",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                        )
                        var total_importe = (viewModel.dataDetalle.cant_administracion * viewModel.dataDetalle.precio_administracion)+(viewModel.dataDetalle.cant_limpieza * viewModel.dataDetalle.precio_limpieza)+(viewModel.dataDetalle.cant_jardineria * viewModel.dataDetalle.precio_jardineria)+(viewModel.dataDetalle.cant_vigilantes * viewModel.dataDetalle.precio_vigilante)
                        Text("$total_importe", color = Color.Red, textAlign = TextAlign.Center)

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email Icon",
                                tint = Color.Black
                            )
                            Text("La cotización fue notificada al cliente")
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { navController.navigate("pantalla1")
                                        viewModel.isLoading = true
                                      },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text("ACEPTAR", color = Color.White)
                        }
                    }else{
                    CircularProgressIndicator(modifier = Modifier.fillMaxSize(), color = Color.Gray)
                    LaunchedEffect(Unit) {
                        if (idSolicitud != null) {
                            viewModel.cargarDataPendiente(idSolicitud)
                        }
                    }
                }

                    }
                }

        },
    )
}





