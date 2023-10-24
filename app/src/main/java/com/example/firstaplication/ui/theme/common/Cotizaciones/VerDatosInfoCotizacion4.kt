package com.example.firstaplication.ui.theme.common.Cotizaciones
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
fun CotiCardVerDatosCotizacion4(cotizacion: Cotizacion) {
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
                Text(text = "Importe administración: ", color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Personal de limpieza: ", color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Jardineros: ", color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Vigilantes: ", color = Color.Black)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "TOTAL cotizado: ", color = Color.Red)
            }
            Column(
                modifier = Modifier.weight(0.3f)
            ) {
                Text(text = cotizacion.importPorAdmin.toString(), color = Color.Blue, modifier = Modifier.align(Alignment.End))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = cotizacion.CotiPersonalLimpieza.toString(), color = Color.Blue, modifier = Modifier.align(Alignment.End))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = cotizacion.CotiJardinero.toString(), color = Color.Blue, modifier = Modifier.align(Alignment.End))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = cotizacion.CotiVigilantes.toString(), color = Color.Blue, modifier = Modifier.align(Alignment.End))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = (cotizacion.importPorAdmin+cotizacion.CotiPersonalLimpieza+cotizacion.CotiJardinero+cotizacion.CotiVigilantes).toString(), color = Color.Blue, modifier = Modifier.align(Alignment.End))
            }
        }
    }
}

