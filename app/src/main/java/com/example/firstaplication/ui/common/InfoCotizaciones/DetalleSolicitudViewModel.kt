package com.example.firstaplication.ui.common.InfoCotizaciones

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.firstaplication.data.dao.solicitud_cotizacionDAO
import androidx.lifecycle.ViewModel
import com.example.firstaplication.data.dao.solicitudDAO
import com.example.firstaplication.data.entity.SolicitudCotizacionEntity
import com.example.firstaplication.data.entity.SolicitudEntity
import com.example.firstaplication.data.model.sData
import com.example.firstaplication.data.model.sDataDetalle
import com.example.firstaplication.data.model.spData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject

@HiltViewModel
class DetalleSolicitudViewModel @Inject constructor(private val scDAO: solicitud_cotizacionDAO,
                                                    private val sDAO: solicitudDAO): ViewModel(){
    var isLoading by mutableStateOf(true)
    val dataDetalle = ArrayList<sDataDetalle>()

    suspend fun generateSolicitudesAprobadas(id: String): ArrayList<SolicitudCotizacionEntity> {
        return withContext(Dispatchers.IO) {
            scDAO.readAprobadaDetalle(id)
        }
    }
    suspend fun generateSolicitudesPendientes(id: String): ArrayList<SolicitudEntity> {
        return withContext(Dispatchers.IO) {
            sDAO.readPendienteDetalle(id)
        }
    }
    fun obtenerDataAprobada(entity: SolicitudCotizacionEntity): sDataDetalle {
        val sData = sDataDetalle()
        sData.nombre = entity.solicitud.solicitante.persona.apellido_paterno + " " + entity.solicitud.solicitante.persona.apellido_materno + " " + entity.solicitud.solicitante.persona.nombres
        sData.nro_documento = entity.solicitud.solicitante.persona.ndocumento
        sData.rol = entity.solicitud.solicitante.rol.descripcion
        sData.correo = entity.solicitud.solicitante.correo
        sData.nombre_predio = entity.solicitud.predio.descripcion
        sData.direccion_predio = entity.solicitud.predio.direccion
        sData.tipo_predio = entity.solicitud.predio.tipo_predio.nombre_predio
        sData.ruc_predio = entity.solicitud.predio.ruc
        sData.cant_vigilantes = entity.solicitud.cant_vigilantes
        sData.precio_vigilante = entity.solicitud.servicio.precio.toDouble()
        sData.cant_limpieza = entity.solicitud.cant_plimpieza
        sData.precio_limpieza = entity.solicitud.servicio.precio.toDouble()
        sData.cant_administracion = entity.solicitud.cant_administracion
        sData.precio_administracion = entity.solicitud.servicio.precio.toDouble()
        sData.cant_jardineria = entity.solicitud.cant_jardineria
        sData.precio_jardineria = entity.solicitud.servicio.precio.toDouble()
        sData.tipo_servicio = entity.solicitud.servicio.descripcion
        return sData
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

    suspend fun guardarDataCotizada(id: String) {
        dataDetalle.clear()
        val solicitudesAprobadas = generateSolicitudesAprobadas(id)
        var result = withContext(Dispatchers.IO) {
            transaction {
                val listData = mutableListOf<sDataDetalle>()
                listData.add(obtenerDataAprobada(solicitudesAprobadas.get(0)))
                listData
            }
        }
        dataDetalle.addAll(result)
    }
    suspend fun guardarDataPendiente(id: String) {
        dataDetalle.clear()
        val solicitudesPendientes = generateSolicitudesPendientes(id)
        var result = withContext(Dispatchers.IO) {
            transaction {
                val listData = mutableListOf<sDataDetalle>()
                listData.add(obtenerDataPendiente(solicitudesPendientes.get(0)))
                listData
            }
        }
        dataDetalle.addAll(result)
    }

    suspend fun cargarDataPendiente(id: String){
        val jobPendiente = CoroutineScope(Dispatchers.IO).launch { guardarDataPendiente(id) }

        // Esperar a que ambas funciones suspendidas finalicen
        jobPendiente.join()
        isLoading = false
    }

    suspend fun cargarDataCotizada(id: String){
        val jobAprobada = CoroutineScope(Dispatchers.IO).launch { guardarDataCotizada(id) }

        // Esperar a que ambas funciones suspendidas finalicen
        jobAprobada.join()
        isLoading = false
    }
}