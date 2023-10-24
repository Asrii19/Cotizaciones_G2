package com.example.firstaplication.ui.common.Solicitudes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CotizacionCardPendiente(solicitud: Solicitud) {
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
                modifier = Modifier.weight(0.6f)
            ) {
                Text(text = solicitud.codigo, color = Color.Red)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = solicitud.nombre, color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = solicitud.zona, color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = solicitud.fecha, color = Color.Red)
            }
            Column(
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight(),
            ) {
                Button(
                    onClick = { /* Abre la opción de cotización */ },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Cotizar")
                }
            }
        }
    }
}