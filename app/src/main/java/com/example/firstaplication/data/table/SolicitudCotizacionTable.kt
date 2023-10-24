package com.example.firstaplication.data.table

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.date

object SolicitudCotizacionTable : LongIdTable("solicitud_cotizacion","id_solicitud_cotizacion") {
    val id_solicitud = integer("id_solicitud")
    val id_personal = integer("id_personal")
    val fecha_cotizacion = date("fecha_cotizacion")
    val importe = double("importe")
    val id_estado = reference("id_estado", EstadoTable.id)
}