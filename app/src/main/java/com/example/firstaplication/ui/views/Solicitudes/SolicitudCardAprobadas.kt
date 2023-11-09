package com.example.firstaplication.ui.views.Solicitudes

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstaplication.data.model.sData

@Composable
fun CotizacionCardAprobada(navController: NavController,data: sData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(0.7f)
            ) {
                Text(text = data.id_solicitud, color = Color.Red)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = data.name, color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = data.namep, color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = data.fechaAprobacion, color = Color.Red)
            }
            Column(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxHeight(),
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .widthIn(max = 100.dp)
                ) {
                    IconButton(
                        onClick = { navController.navigate("VisualizacionCotizarAprobada/${data.id_solicitud}") }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Ver Cotización",
                            tint = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* Abre la opción de cotización */ },
                    modifier = Modifier
                        .widthIn(max = 100.dp)
                ) {
                    IconButton(
                        onClick = { /* Acción para descargar la cotización */ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = "Descargar Cotización",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}
