package com.example.firstaplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.firstaplication.data.config.db
import com.example.firstaplication.ui.common.Solicitudes.SolicitudViewModel
import com.example.firstaplication.ui.common.Solicitudes.SolicitudesScreen
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.firstaplication.ui.common.Solicitudes.VisualizacionSolicitudCotizadaScreen
import com.example.firstaplication.ui.theme.FirstAplicationTheme
import com.example.firstaplication.ui.theme.common.InfoCotizaciones.VisualizacionCotiRegistradaScreen
import com.example.firstaplication.ui.theme.common.InfoCotizaciones.VisualizacionCotisScreen
import dagger.hilt.android.AndroidEntryPoint
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.varia.NullAppender

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val solicitudViewModel: SolicitudViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
        BasicConfigurator.configure(NullAppender()) // para el log4jzzz
        db.init() //inicializo la db
        setContent {
            val navController = rememberNavController() // Crear el controlador de navegación
            // Configurar la navegación con Navigation Component
            NavHost(
                navController = navController,
                startDestination = "pantalla1"
            ) {
                composable("pantalla1") {
                    // Pantalla 1
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        SolicitudesScreen(solicitudViewModel,navController)
                    }
                }
                composable("VisualizacionCotizarPendiente") {
                    VisualizacionCotiRegistradaScreen(navController)
                }
                composable("VisualizacionCotizarAprobada") {
                    VisualizacionCotisScreen(navController)
                }
                composable("VisualizaracionSolicitudCotizada"){
                    VisualizacionSolicitudCotizadaScreen(navController)
                }

            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
}
