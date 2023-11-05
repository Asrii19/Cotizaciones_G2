package com.example.firstaplication.utils

import androidx.compose.material3.darkColorScheme
import com.example.firstaplication.data.config.db
import com.example.firstaplication.data.dao.solicitudDAO
import com.example.firstaplication.data.dao.solicitud_cotizacionDAO
import com.example.firstaplication.data.model.spData
import com.example.firstaplication.ui.common.Solicitudes.SolicitudViewModel
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.varia.NullAppender


fun main(){
    BasicConfigurator.configure(NullAppender()) // para el log4jzzz
    db.init()
    val scdao = solicitud_cotizacionDAO()
    val sdao = solicitudDAO()
    val vm = SolicitudViewModel(scdao,sdao)
    val deferred = CompletableDeferred<Unit>()
    var spDataPendiente = ArrayList<spData>()

    GlobalScope.launch(Dispatchers.IO) {
        vm.guardarDataPendiente()
        deferred.complete(Unit)
    }

    runBlocking {
        deferred.await() // Espera a que la coroutine termine
        println("La coroutine ha terminado")
    }

    //val response = vm.generateSolicitudesPendientes()
    /*transaction {
        response.forEach{e->
            println("La solicitud con id=${e.id}")
            //println("La solicitud con id=${e.id}, id_solicitud=${e.solicitud.id} estado= ${e.estado.id} tiene como descripcion ${e.estado.descripcion}")
            //println("Tiene como personal a ${e.personal.persona.nombres} con id_personal ${e.personal.id}, con id_persona ${e.personal.persona.id}")
            println("-----------")
        }
    }*/
    spDataPendiente.forEach{data->
        println(data.id_solicitud)
    }
}