package com.example.firstaplication.data.model

import org.jetbrains.exposed.dao.id.EntityID
import java.math.BigDecimal
import java.time.LocalDate

data class Solicitud(
    val id_solicitud: EntityID<Int>,
    val id_predio: EntityID<Int>,
    val id_solicitante: EntityID<Int>,
    val id_servicio: EntityID<Int>,
    val area_predio: BigDecimal,
    val num_casas: Int,
    val cant_acomunes: Int,
    val area_acomunes: Int,
    val cant_vigilantes: Int,
    val cant_plimpieza: Int,
    val cant_administracion: Int,
    val cant_jardineria: Int,
    val fecha_solicitud: LocalDate
)
