package com.example.firstaplication.ui.common.Solicitudes

import com.example.firstaplication.data.dao.solicitud_cotizacionDAO
import androidx.lifecycle.ViewModel
import com.example.firstaplication.data.entity.SolicitudCotizacionEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject

@HiltViewModel
class SolicitudViewModel @Inject constructor(private val scDAO: solicitud_cotizacionDAO): ViewModel(){
    object solicitud_data {
        var id_solicitud:String = ""
        var name:String = ""
        var namep:String = ""
        var fecha:String = ""
    }
    fun generateSolicitudesPendientes(): ArrayList<SolicitudCotizacionEntity> {
        val data = scDAO.readPendientes()
        return data
    }
    fun obtener_data(entity: SolicitudCotizacionEntity): solicitud_data {
        CoroutineScope(Dispatchers.IO).launch {
            transaction{
                solicitud_data.id_solicitud = entity.solicitud.id.toString().padStart(6, '0')
                solicitud_data.name = entity.solicitud.solicitante.persona.apellido_paterno + " " + entity.solicitud.solicitante.persona.apellido_materno + " " + entity.solicitud.solicitante.persona.nombres
                solicitud_data.namep = entity.solicitud.predio.descripcion
                solicitud_data.fecha = entity.solicitud.fecha_solicitud.toString()
            }
        }
        return solicitud_data
    }
}