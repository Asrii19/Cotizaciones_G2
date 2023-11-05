package com.example.firstaplication.data.dao

import com.example.firstaplication.data.entity.SolicitudCotizacionEntity
import com.example.firstaplication.data.model.SolicitudCotizacion
import com.example.firstaplication.data.table.SolicitudCotizacionTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject

class solicitud_cotizacionDAO @Inject constructor() : CRUD<ArrayList<SolicitudCotizacion>> {
    override fun create(item: ArrayList<SolicitudCotizacion>) {
        TODO("Not yet implemented")
    }

    override fun read(): ArrayList<SolicitudCotizacion> { //primero
        return runBlocking {
            withContext(Dispatchers.IO) {
                val result = ArrayList<SolicitudCotizacion>()

                transaction {
                    val query = SolicitudCotizacionTable.selectAll()
                    query.forEach {
                        val id_solicitud = it[SolicitudCotizacionTable.id_solicitud]
                        val id_personal = it[SolicitudCotizacionTable.id_personal]
                        val fecha_cotizacion = it[SolicitudCotizacionTable.fecha_cotizacion]
                        val importe = it[SolicitudCotizacionTable.importe]
                        val id_solicitud_cotizacion = it[SolicitudCotizacionTable.id]
                        val id_estado = it[SolicitudCotizacionTable.id_estado]
                        result.add(SolicitudCotizacion(
                            id_solicitud,
                            id_personal,
                            fecha_cotizacion,
                            importe,
                            id_solicitud_cotizacion,
                            id_estado
                        ))
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
    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(item: ArrayList<SolicitudCotizacion>) {
        TODO("Not yet implemented")
    }

}