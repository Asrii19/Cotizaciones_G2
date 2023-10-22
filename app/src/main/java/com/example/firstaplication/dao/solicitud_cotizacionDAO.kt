package com.example.firstaplication.dao

import com.example.firstaplication.models.solicitud_cotizacion
import com.example.firstaplication.config.connection
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class solicitud_cotizacionDAO: CRUD<ArrayList<solicitud_cotizacion>>  {
    private val con = connection()
    override fun create(item: ArrayList<solicitud_cotizacion>) {
        TODO("Not yet implemented")
    }

    override fun read(): ArrayList<solicitud_cotizacion>? { //primero
        try {
            val solicitudCotizacionList = ArrayList<solicitud_cotizacion>()
            val conex: Connection? = con.connect()
            val st = conex?.createStatement()
            val rs: ResultSet = st?.executeQuery("SELECT * FROM solicitud_cotizacion") ?: throw error("error READ")
            while (rs.next()) {
                val solicitudCotizacion = solicitud_cotizacion(
                    rs.getInt("id_solicitud"),
                    rs.getInt("id_personal"),
                    rs.getDate("fecha_cotizacion"),
                    rs.getDouble("importe"),
                    rs.getInt("id_solicitud_cotizacion"),
                    rs.getInt("id_estado")
                )
                solicitudCotizacionList.add(solicitudCotizacion)
            }
            rs.close()
            st?.close()
            conex?.close()

            return solicitudCotizacionList
        } catch (ex: SQLException) {
            println(ex.message)
            println("Error en listado")
        }
        return null
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun update(item: ArrayList<solicitud_cotizacion>) {
        TODO("Not yet implemented")
    }

}