package com.example.firstaplication.utils

import com.example.firstaplication.data.config.db
import com.example.firstaplication.data.dao.solicitud_cotizacionDAO

fun main(){
    db.init()
    val scDAO = solicitud_cotizacionDAO()
    val response = scDAO.read()
    println(response)
}