package com.example.firstaplication.config

import com.example.firstaplication.utils.getLocalProperty
import java.sql.DriverManager
import java.util.Properties
import java.sql.Connection

class connection{
    private val user = getLocalProperty("USER") ?: ""
    private val password = getLocalProperty("PASSWORD") ?: ""
    private val database = getLocalProperty("DATABASE") ?: ""
    private val host = getLocalProperty("HOST") ?: ""

    fun connect(): Connection? {
        try {
            val url = "jdbc:postgresql://$host/$database"
            val properties = Properties()
            properties.setProperty("user", user)
            properties.setProperty("password", password)
            // Establecer la conexión
            return DriverManager.getConnection(url, properties)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}
