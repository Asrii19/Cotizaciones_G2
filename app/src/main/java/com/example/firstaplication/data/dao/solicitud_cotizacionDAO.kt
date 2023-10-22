package com.example.firstaplication.data.dao

import com.example.firstaplication.data.model.solicitud_cotizacion
import com.example.firstaplication.data.table.solicitud_cotizacionTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate

// VARIABLES GLOBALES
val DFECHA_COTIZACION: LocalDate = LocalDate.of(2023, 12, 12)
class solicitud_cotizacionDAO: CRUD<ArrayList<solicitud_cotizacion>> {
    override fun create(item: ArrayList<solicitud_cotizacion>) {
        TODO("Not yet implemented")
    }

    override fun read(): ArrayList<solicitud_cotizacion> { //primero
        return runBlocking {
            withContext(Dispatchers.IO) {
                val result = ArrayList<solicitud_cotizacion>()

                transaction {
                    val query = solicitud_cotizacionTable.selectAll()
                    query.forEach {
                        val id_solicitud = it[solicitud_cotizacionTable.id_solicitud]
                        val id_personal = it[solicitud_cotizacionTable.id_personal]
                        val fecha_cotizacion = it[solicitud_cotizacionTable.fecha_cotizacion]
                        val importe = it[solicitud_cotizacionTable.importe]
                        val id_solicitud_cotizacion = it[solicitud_cotizacionTable.id_solicitud_cotizacion]
                        val id_estado = it[solicitud_cotizacionTable.id_estado]
                        result.add(solicitud_cotizacion(
                            id_solicitud,
                            id_personal,
                            fecha_cotizacion ?: DFECHA_COTIZACION,
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

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(item: ArrayList<solicitud_cotizacion>) {
        TODO("Not yet implemented")
    }

}