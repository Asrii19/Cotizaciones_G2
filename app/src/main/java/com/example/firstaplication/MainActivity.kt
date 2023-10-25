package com.example.firstaplication

import android.os.Bundle
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
import com.example.firstaplication.ui.theme.FirstAplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.varia.NullAppender

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val solicitudViewModel: SolicitudViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BasicConfigurator.configure(NullAppender()) // para el log4jzzz
        db.init() //inicializo la db
        setContent {
            FirstAplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SolicitudesScreen(solicitudViewModel)
                }
            }
        }
    }
}
