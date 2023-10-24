package com.example.firstaplication.data.entity

import com.example.firstaplication.data.table.SolicitudCotizacionTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class SolicitudCotizacionEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<SolicitudCotizacionEntity>(SolicitudCotizacionTable)

    var id_solicitud by SolicitudCotizacionTable.id_solicitud
    var id_personal by SolicitudCotizacionTable.id_personal
    var fecha_cotizacion by SolicitudCotizacionTable.fecha_cotizacion
    var importe by SolicitudCotizacionTable.importe
    var estado by EstadoEntity referencedOn SolicitudCotizacionTable.id_estado
}