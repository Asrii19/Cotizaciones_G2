package com.example.firstaplication.data.table

import org.jetbrains.exposed.dao.id.IntIdTable

object TipoPredioTable : IntIdTable("tipo_predio", "id_tipo_predio") {
    val nombre_predio = varchar("nombre_predio", 255)
}