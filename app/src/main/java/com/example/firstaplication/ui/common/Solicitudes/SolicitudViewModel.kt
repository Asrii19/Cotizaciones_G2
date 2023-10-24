package com.example.firstaplication.ui.common.Solicitudes

import com.example.firstaplication.data.dao.solicitud_cotizacionDAO
import androidx.lifecycle.ViewModel
import com.example.firstaplication.data.entity.SolicitudCotizacionEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SolicitudViewModel @Inject constructor(private val scDAO: solicitud_cotizacionDAO): ViewModel(){

    fun generateSolicitudesPendientes(): ArrayList<SolicitudCotizacionEntity> {
        val data = scDAO.readPendientes()

        return data
    }
}