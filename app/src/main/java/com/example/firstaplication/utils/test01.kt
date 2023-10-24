package com.example.firstaplication.utils

import com.example.firstaplication.data.config.db
import com.example.firstaplication.data.dao.solicitud_cotizacionDAO
import com.example.firstaplication.ui.common.Solicitudes.SolicitudViewModel
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.varia.NullAppender
import org.jetbrains.exposed.sql.transactions.transaction


fun main(){
    BasicConfigurator.configure(NullAppender()) // para el log4jzzz
    db.init()
    val scdao = solicitud_cotizacionDAO()
    val vm = SolicitudViewModel(scdao)
    val response = vm.generateSolicitudesPendientes()
    transaction {
        response.forEach{e->
            println("La solicitud con id=${e.id} estado= ${e.estado.id} tiene como descripcion ${e.estado.descripcion}")
            println("Tiene como personal a ${e.personal.persona.nombres} con id_personal ${e.personal.id}, con id_persona ${e.personal.persona.id}")
            println("-----------")
        }
    }
}