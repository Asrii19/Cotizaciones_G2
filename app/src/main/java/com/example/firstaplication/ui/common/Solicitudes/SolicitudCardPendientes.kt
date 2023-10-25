package com.example.firstaplication.ui.common.Solicitudes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.firstaplication.data.entity.SolicitudCotizacionEntity

@Composable
fun CotizacionCardPendiente(solicitud: SolicitudCotizacionEntity,viewModel: SolicitudViewModel) {

    var data by remember { mutableStateOf(SolicitudViewModel.solicitud_data) }

    LaunchedEffect(Unit) {
        data = viewModel.obtener_data(solicitud)
    }

    if (data != null) {
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
                    Text(text = data.id_solicitud, color = Color.Red)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = data.name, color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = data.namep, color = Color.Black)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = data.fecha, color = Color.Red)
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
    } else {
        // Muestra un indicador de carga o un mensaje de espera
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

}