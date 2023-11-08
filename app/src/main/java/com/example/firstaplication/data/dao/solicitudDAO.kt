package com.example.firstaplication.data.dao

import com.example.firstaplication.data.entity.SolicitudCotizacionEntity
import com.example.firstaplication.data.entity.SolicitudEntity
import com.example.firstaplication.data.model.Solicitud
import com.example.firstaplication.data.model.SolicitudCotizacion
import com.example.firstaplication.data.table.SolicitudCotizacionTable
import com.example.firstaplication.data.table.SolicitudTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate
import javax.inject.Inject

class solicitudDAO @Inject constructor() : CRUD<ArrayList<Solicitud>> {
    override fun create(item: ArrayList<Solicitud>) {
        TODO("Not yet implemented")
    }

    override fun read(): ArrayList<Solicitud> { //primero
        return runBlocking {
            withContext(Dispatchers.IO) {
                val result = ArrayList<Solicitud>()

                transaction {
                    val query = SolicitudTable.selectAll()
                    query.forEach {
                        val id_solicitud = it[SolicitudTable.id]
                        val id_predio = it[SolicitudTable.id_predio]
                        val id_solicitante = it[SolicitudTable.id_solicitante]
                        val id_servicio = it[SolicitudTable.id_servicio]
                        val area_predio = it[SolicitudTable.area_predio]
                        val num_casas = it[SolicitudTable.num_casas]
                        val cant_acomunes = it[SolicitudTable.cant_acomunes]
                        val area_acomunes = it[SolicitudTable.area_acomunes]
                        val cant_vigilantes = it[SolicitudTable.cant_vigilantes]
                        val cant_plimpieza = it[SolicitudTable.cant_plimpieza]
                        val cant_administracion = it[SolicitudTable.cant_administracion]
                        val cant_jardineria = it[SolicitudTable.cant_jardineria]
                        val fecha_solicitud = it[SolicitudTable.fecha_solicitud]
                        result.add(
                            Solicitud(
                            id_solicitud,
                            id_predio,
                            id_solicitante,
                            id_servicio,
                            area_predio,
                            num_casas,
                            cant_acomunes,
                            area_acomunes,
                            cant_vigilantes,
                            cant_plimpieza,
                            cant_administracion,
                            cant_jardineria,
                            fecha_solicitud,
                        )
                        )
                    }
                }
                result
            }
        }
    }
    fun readPendientes(): ArrayList<SolicitudEntity>{
        return runBlocking {
            withContext(Dispatchers.IO) {
                val result = ArrayList<SolicitudEntity>()
                transaction {
                    val query = SolicitudEntity.all()
                    query.forEach { e ->
                        result.add(e)
                    }
                }
                result
            }
        }
    }

    fun readPendienteDetalle(id: String): ArrayList<SolicitudEntity>{
        val id2 = id.toInt()

        return runBlocking {
            withContext(Dispatchers.IO) {
                val result = ArrayList<SolicitudEntity>()
                transaction {
                    val query = SolicitudEntity.findById(id2)
                    if (query != null) {
                        result.add(query)
                    }
                }
                result
            }
        }
    }
    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(item: ArrayList<Solicitud>) {
        TODO("Not yet implemented")
    }

}