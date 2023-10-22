package com.example.firstaplication.data.model

import java.time.LocalDate

data class solicitud_cotizacion(
    val id_solicitud: Int,
    val id_personal: Int,
    val fecha_cotizacion: LocalDate,
    val importe: Double,
    val id_solicitud_cotizacion: Int,
    val id_estado: Int
)