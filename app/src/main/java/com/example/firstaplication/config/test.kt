package com.example.firstaplication.config

import com.example.firstaplication.dao.solicitud_cotizacionDAO
import com.example.firstaplication.models.solicitud_cotizacion

fun main(){
    val scDAO = solicitud_cotizacionDAO()
    val importes: ArrayList<solicitud_cotizacion>? = scDAO.read()
    println(importes)
}