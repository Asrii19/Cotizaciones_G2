package com.example.firstaplication.ui.theme.common.InfoCotizaciones
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CotiCardVerDatosPredio2(cotizacion: Cotizacion) {
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
                Text(text = "Nombre: ", color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Dirección: ", color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Tipo de predio: ", color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "RUC: ", color = Color.Black)
            }
            Column(
                modifier = Modifier.weight(0.6f)
            ) {
                Text(text = cotizacion.nombrePredio, color = Color.Blue, modifier = Modifier.align(Alignment.End))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = cotizacion.direccion, color = Color.Blue, modifier = Modifier.align(Alignment.End))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = cotizacion.tipoPredio, color = Color.Blue, modifier = Modifier.align(Alignment.End))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = cotizacion.RUC, color = Color.Blue, modifier = Modifier.align(Alignment.End))
            }
        }
    }
}

