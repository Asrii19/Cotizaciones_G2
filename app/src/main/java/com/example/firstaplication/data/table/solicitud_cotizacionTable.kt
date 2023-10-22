package com.example.firstaplication.data.table

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object solicitud_cotizacionTable : Table("solicitud_cotizacion") {

    val id_solicitud = integer("id_solicitud")
    val id_personal = integer("id_personal")
    val fecha_cotizacion = date("fecha_cotizacion")
    val importe = double("importe")
    val id_solicitud_cotizacion = integer("id_solicitud_cotizacion").autoIncrement()
    val id_estado = integer("id_estado")

    override val primaryKey = PrimaryKey(id_solicitud)
}