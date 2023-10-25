package com.example.firstaplication.ui.common.Solicitudes

import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import com.example.firstaplication.ui.theme.common.InfoCotizaciones.CotiCardVerDatosCotizacion4
import com.example.firstaplication.ui.theme.common.InfoCotizaciones.CotiCardVerDatosPersonal1
import com.example.firstaplication.ui.theme.common.InfoCotizaciones.CotiCardVerDatosPredio2
import com.example.firstaplication.ui.theme.common.InfoCotizaciones.CotiCardVerDatosServicios3
import com.example.firstaplication.ui.theme.common.InfoCotizaciones.Cotizacion
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
import com.example.firstaplication.ui.theme.FirstAplicationTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualizacionSolicitudCotizadaScreen(navController: NavController) {
    // Data de usuario
    val cotizacionObjeto = generateCotizaciones3() // Reemplaza con tus datos reales de la base de datos

    Scaffold(
        contentColor = Color(0xFF000080),
        containerColor = Color(0xFF000080),
        topBar = {
            TopAppBar(
                modifier = Modifier.height(60.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color(0xFF000080)),
                title = {
                    Text(
                        text = cotizacionObjeto[0].codigo,
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
                    Text(
                        text = "COTIZACIÓN REALIZADA CON ÉXITO",
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Información de la cotización:", modifier = Modifier)

                    Text("Predio: Las Mariposas", modifier = Modifier)
                    Text("Tipo: Condominio", modifier = Modifier)
                    Text("Cliente: Quintana Ramirez Fabrizzio", modifier = Modifier)

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "TOTAL COTIZADO:",
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                    )
                    Text("2500.00", color = Color.Red, textAlign = TextAlign.Center)

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
                        onClick = { navController.navigate("pantalla1")},
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text("ACEPTAR", color = Color.White)
                    }
                }
            }
        },
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





