package com.example.firstaplication

import com.example.firstaplication.data.config.db
import com.example.firstaplication.data.dao.solicitud_cotizacionDAO
import com.example.firstaplication.ui.common.Solicitudes.SolicitudViewModel
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun dataSolicitudes() {
        db.init()
        val scdao = solicitud_cotizacionDAO()
        val vm = SolicitudViewModel(scdao)
        val response = vm.generateSolicitudesPendientes()
        println(response)
    }
}