package com.example.firstaplication.models

import java.sql.Date

data class solicitud_cotizacion (
    val id_solicitud: Int,
    val id_personal: Int,
    val fecha_cotizacion: Date,
    val importe: Double,
    val id_solicitud_cotizacion: Int,
    val id_estado: Int
)