package com.example.firstaplication.ui.views.infoSolicitudes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.firstaplication.data.dao.solicitud_cotizacionDAO
import androidx.lifecycle.ViewModel
import com.example.firstaplication.data.dao.solicitudDAO
import com.example.firstaplication.data.entity.SolicitudCotizacionEntity
import com.example.firstaplication.data.entity.SolicitudEntity
import com.example.firstaplication.data.model.sDataDetalle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject

@HiltViewModel
class DetalleSolicitudViewModel @Inject constructor(private val sDAO: solicitudDAO): ViewModel(){
    var isLoading by mutableStateOf(true)
    var dataDetalle = sDataDetalle()
    suspend fun generateSolicitudesPendientes(id: String): ArrayList<SolicitudEntity> {
        return withContext(Dispatchers.IO) {
            sDAO.readPendienteDetalle(id)
        }
    }
    fun obtenerDataPendiente(entity: SolicitudEntity): sDataDetalle {
        val sData = sDataDetalle()
        sData.nombre = entity.solicitante.persona.apellido_paterno + " " + entity.solicitante.persona.apellido_materno + " " + entity.solicitante.persona.nombres
        sData.nro_documento = entity.solicitante.persona.ndocumento
        sData.rol = entity.solicitante.rol.descripcion
        sData.correo = entity.solicitante.correo
        sData.nombre_predio = entity.predio.descripcion
        sData.direccion_predio = entity.predio.direccion
        sData.tipo_predio = entity.predio.tipo_predio.nombre_predio
        sData.ruc_predio = entity.predio.ruc
        sData.cant_vigilantes = entity.cant_vigilantes
        sData.precio_vigilante = entity.servicio.precio.toDouble()
        sData.cant_limpieza = entity.cant_plimpieza
        sData.precio_limpieza = entity.servicio.precio.toDouble()
        sData.cant_administracion = entity.cant_administracion
        sData.precio_administracion = entity.servicio.precio.toDouble()
        sData.cant_jardineria = entity.cant_jardineria
        sData.precio_jardineria = entity.servicio.precio.toDouble()
        sData.tipo_servicio = entity.servicio.descripcion
        return sData
    }

    suspend fun guardarDataPendiente(id: String) {
        val solicitudesPendientes = generateSolicitudesPendientes(id)
        var result = withContext(Dispatchers.IO) {
            transaction {
                var Data = sDataDetalle()
                Data = obtenerDataPendiente(solicitudesPendientes.get(0))
                Data
            }
        }
        dataDetalle = result
    }

    suspend fun cargarDataPendiente(id: String){
        val jobPendiente = CoroutineScope(Dispatchers.IO).launch { guardarDataPendiente(id) }

        jobPendiente.join()
        isLoading = false
    }
}