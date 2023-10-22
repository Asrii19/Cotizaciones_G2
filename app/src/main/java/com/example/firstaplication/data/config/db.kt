package com.example.firstaplication.data.config

import com.example.firstaplication.utils.getLocalProperty
import org.jetbrains.exposed.sql.Database
object db {
    private val _user = getLocalProperty("USER") ?: ""
    private val _password = getLocalProperty("PASSWORD") ?: ""
    private val _database = getLocalProperty("DATABASE") ?: ""
    private val _host = getLocalProperty("HOST") ?: ""
    fun init() {
        Database.connect(
            url = "jdbc:postgresql://$_host/$_database",
            driver = "org.postgresql.Driver",
            user = _user,
            password = _password,
        )
    }
}