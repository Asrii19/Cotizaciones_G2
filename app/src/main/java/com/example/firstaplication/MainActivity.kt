package com.example.firstaplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstaplication.data.config.db
import com.example.firstaplication.ui.common.Solicitudes.CotizacionesScreen
import com.example.firstaplication.ui.theme.FirstAplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db.init() //inicializo la db
        setContent {
            FirstAplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CotizacionesScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewMain(){
    CotizacionesScreen()
}
