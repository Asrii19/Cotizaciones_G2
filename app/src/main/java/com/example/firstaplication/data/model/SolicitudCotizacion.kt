package com.example.firstaplication.data.model

import org.jetbrains.exposed.dao.id.EntityID
import java.time.LocalDate

data class SolicitudCotizacion(
    val id_solicitud: EntityID<Int>,
    val id_personal: EntityID<Int>,
    val fecha_cotizacion: LocalDate,
    val importe: Double,
    val id_solicitud_cotizacion: EntityID<Long>,
    val id_estado: EntityID<Int>
)