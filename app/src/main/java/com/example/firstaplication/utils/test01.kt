package com.example.firstaplication.utils

import androidx.compose.material3.darkColorScheme
import com.example.firstaplication.data.config.db
import com.example.firstaplication.data.dao.solicitudDAO
import com.example.firstaplication.data.dao.solicitud_cotizacionDAO
import com.example.firstaplication.data.model.spData
import com.example.firstaplication.ui.views.Solicitudes.SolicitudViewModel
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.varia.NullAppender
import org.jetbrains.exposed.sql.transactions.transaction


fun main(){
    BasicConfigurator.configure(NullAppender()) // para el log4jzzz
    db.init()
    val scdao = solicitud_cotizacionDAO()
    val sdao = solicitudDAO()
    val vm = SolicitudViewModel(scdao,sdao)
    val response = sdao.readPendienteDetalle("000050")
    transaction{
        print(response.get(0).solicitante.persona.apellido_paterno)
    }
}