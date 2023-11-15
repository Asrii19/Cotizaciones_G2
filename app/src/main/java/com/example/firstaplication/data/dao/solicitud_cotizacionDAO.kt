package com.example.firstaplication.data.dao

import com.example.firstaplication.data.entity.SolicitudCotizacionEntity
import com.example.firstaplication.data.entity.SolicitudEntity
import com.example.firstaplication.data.model.SolicitudCotizacion
import com.example.firstaplication.data.table.SolicitudCotizacionTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.dao.DaoEntityID
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.max
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject

class solicitud_cotizacionDAO @Inject constructor() {
    fun create(solicitudCotizacion: SolicitudCotizacion,idSolicitudCotizacion: Long) {
        runBlocking {
            withContext(Dispatchers.IO) {
                transaction {
                    SolicitudCotizacionTable.insert {
                        it[id_personal] = solicitudCotizacion.id_personal
                        it[fecha_cotizacion] = solicitudCotizacion.fecha_cotizacion
                        it[importe] = solicitudCotizacion.importe
                        it[id_solicitud] = solicitudCotizacion.id_solicitud
                        it[id_estado] = solicitudCotizacion.id_estado
                        it[id] = idSolicitudCotizacion
                    }.resultedValues!!.map { it[SolicitudCotizacionTable.id] }.first()
                }
            }
        }
    }
    fun generateMaxId():Long {
        return runBlocking {
            withContext(Dispatchers.IO) {
                transaction {
                    val maxIdResult = SolicitudCotizacionTable
                        .slice(SolicitudCotizacionTable.id.max())
                        .selectAll()
                        .singleOrNull()

                    val maxId = maxIdResult?.get(SolicitudCotizacionTable.id.max()) as DaoEntityID?
                    maxId?.value ?: 1
                }
            }
        }
    }
    fun readAprobadaDetalle(id: String): ArrayList<SolicitudCotizacionEntity>{
        val id2 = id.toLong()

        return runBlocking {
            withContext(Dispatchers.IO) {
                val result = ArrayList<SolicitudCotizacionEntity>()
                transaction {
                    val query = SolicitudCotizacionEntity.findById(id2)
                    if (query != null) {
                        result.add(query)
                    }
                }
                result
            }
        }
    }
    fun readAprobadas(): ArrayList<SolicitudCotizacionEntity>{
        return runBlocking {
            withContext(Dispatchers.IO) {
                val result = ArrayList<SolicitudCotizacionEntity>()
                transaction {
                    val query = SolicitudCotizacionEntity.all()
                    query.forEach { e ->
                        result.add(e)
                    }
                }
                result
            }
        }
    }
}