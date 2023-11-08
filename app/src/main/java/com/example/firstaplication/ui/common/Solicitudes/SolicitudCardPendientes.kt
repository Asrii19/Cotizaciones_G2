package com.example.firstaplication.ui.common.Solicitudes

import android.content.ContentResolver.ANY_CURSOR_ITEM_TYPE
import android.content.ContentResolver.CURSOR_DIR_BASE_TYPE
import android.content.Context
import android.provider.Settings.Global.putInt
import android.provider.Settings.Global.putString
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextMotion.Companion.Static
import androidx.compose.ui.unit.dp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import com.example.firstaplication.data.model.spData

@Composable
fun CotizacionCardPendiente(navController: NavController,data: spData) {
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
                Text(text = data.fechaSolicitud, color = Color.Red)
            }
            Column(
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxHeight(),
            ) {
                Button(
                    onClick = {
                        navController.navigate("VisualizacionCotizarPendiente/${data.id_solicitud}")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Cotizar")
                }
            }
        }
   }
}



