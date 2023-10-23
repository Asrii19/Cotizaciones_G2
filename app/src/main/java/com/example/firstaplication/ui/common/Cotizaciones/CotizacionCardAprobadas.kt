package com.example.firstaplication.ui.common.Cotizaciones

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

@Composable
fun CotizacionCardAprobada(cotizacion: Cotizacion) {
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
                Text(text = cotizacion.codigo, color = Color.Red)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = cotizacion.nombre, color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = cotizacion.zona, color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = cotizacion.fecha, color = Color.Red)
            }
            Column(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxHeight(),
            ) {
                Button(
                    onClick = { /* Abre la opción de cotización */ },
                    modifier = Modifier
                        .widthIn(max = 100.dp)
                ) {
                    IconButton(
                        onClick = { /* Acción para descargar la cotización */ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Ver Cotización",
                            tint = Color.Black
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
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}
