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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualizacionSolicitudCotizadaScreen(navController: NavController) {

    Scaffold(
        contentColor = Color(0xFF000080),
        containerColor = Color(0xFF000080),
        topBar = {
            TopAppBar(
                modifier = Modifier.height(60.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color(0xFF000080)),
                title = {
                    Text(
                        text = "000001",
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





