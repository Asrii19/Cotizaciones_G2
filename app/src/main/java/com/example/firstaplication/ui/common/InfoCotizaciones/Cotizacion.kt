package com.example.firstaplication.ui.theme.common.InfoCotizaciones

    class Cotizacion{
    var codigo: String=""
    var nombre: String=""
    var zona: String=""
    var fecha: String=""
    var numDoc:String=""
    var rol:String=""
    var correo:String=""
    var nombrePredio: String=""
    var direccion: String=""
    var tipoPredio:String=""
    var RUC:String=""

    var cantAdmin: Int=0
    var cantPersonalLimpieza: Int=0
    var cantJardineros:Int=0
    var cantVigilantes:Int=0
    var tipoServ:String=""

    var importPorAdmin: Double=0.0
    var CotiPersonalLimpieza: Double=0.0
    var CotiJardinero:Double=0.0
    var CotiVigilantes:Double=0.0

    constructor(_codigo:String,_nombre:String,_zona:String,_fecha:String){
        this.codigo=_codigo
        this.nombre=_nombre
        this.zona=_zona
        this.fecha=_fecha
    }
}
