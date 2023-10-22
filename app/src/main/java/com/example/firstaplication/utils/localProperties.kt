package com.example.firstaplication.utils

import java.io.FileInputStream
import java.util.*

fun getLocalProperty(key: String): String? {
    val properties = Properties()

    try {
        val localPropertiesFile = FileInputStream("local.properties")
        properties.load(localPropertiesFile)
        localPropertiesFile.close()
    } catch (e: Exception) {
        e.printStackTrace()
        return null
    }

    return properties.getProperty(key)
}