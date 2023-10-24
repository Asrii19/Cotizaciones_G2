package com.example.firstaplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstaplication.ui.theme.FirstAplicationTheme
import com.example.firstaplication.ui.theme.common.Cotizaciones.Cotizacion
import com.example.firstaplication.ui.theme.common.Cotizaciones.CotizacionCardPendiente
import com.example.firstaplication.ui.theme.common.Cotizaciones.CotizacionesAprobadasScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CotizacionesAprobadasScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(text = "HOLAAAA")
    Row(
        modifier = Modifier.fillMaxSize(),
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAplicationTheme {
        CotizacionesAprobadasScreen()
    }
}