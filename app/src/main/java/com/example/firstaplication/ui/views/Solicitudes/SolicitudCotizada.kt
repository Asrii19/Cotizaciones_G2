package com.example.firstaplication.ui.views.Solicitudes

import androidx.compose.material.icons.filled.Email
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.firstaplication.data.config.db
import com.example.firstaplication.ui.views.infoSolicitudes.DetalleSolicitudViewModel
import java.sql.Date
import java.sql.DriverManager
import java.sql.SQLException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualizacionSolicitudCotizadaScreen(context: Context,viewModel: DetalleSolicitudViewModel, navController: NavController,idSolicitud: String?) {
    viewModel.isLoading = true
    Scaffold(
        contentColor = Color(0xFF000080),
        containerColor = Color(0xFF000080),
        topBar = {
            TopAppBar(
                modifier = Modifier.height(60.dp),
                colors = TopAppBarDefaults.mediumTopAppBarColors(Color(0xFF000080)),
                title = {
                    Text(
                        text = idSolicitud.toString(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                            .fillMaxHeight()
                            .wrapContentSize(Alignment.Center)
                    )
                },
            )
        },

        //CUERPO

        content = { innerPadding ->
            if (!viewModel.isLoading){
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding) // Para centrar horizontalmente
                        .background(Color(0xFF000080))
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.TopCenter)
                        .fillMaxHeight()
                        .wrapContentSize(Alignment.Center)
                ) {

                    Text(
                        text = "COTIZACIÓN REALIZADA CON ÉXITO",
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("Información de la cotización:", modifier = Modifier,fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(8.dp))
                        Text("Predio:     ${viewModel.dataDetalle.nombre_predio}", modifier = Modifier.fillMaxWidth(),fontWeight = FontWeight.Bold)
                        Text("Tipo:         ${viewModel.dataDetalle.tipo_predio}", modifier = Modifier.fillMaxWidth(),fontWeight = FontWeight.Bold)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text("Cliente:    ${viewModel.dataDetalle.nombre}", modifier = Modifier.fillMaxWidth(),overflow = TextOverflow.Visible,fontWeight = FontWeight.Bold)
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "TOTAL COTIZADO:",
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                        )
                        var total_importe = (viewModel.dataDetalle.cant_administracion * viewModel.dataDetalle.precio_administracion)+(viewModel.dataDetalle.cant_limpieza * viewModel.dataDetalle.precio_limpieza)+(viewModel.dataDetalle.cant_jardineria * viewModel.dataDetalle.precio_jardineria)+(viewModel.dataDetalle.cant_vigilantes * viewModel.dataDetalle.precio_vigilante)
                        Text("$total_importe", color = Color.Red, textAlign = TextAlign.Center,fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email Icon",
                                tint = Color.Black
                            )
                            Text("La cotización fue notificada al cliente")
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {
                                navController.navigate("pantalla1")


                                /*
                                //Acá debo de hacer el insert
                                val fechaActual = LocalDate.now()
                                // Define el formato de la cadena de fecha si es necesario
                                val formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                                // Convierte la fecha actual a String
                                val fechaActualString = fechaActual.format(formatoFecha)

                                val idSoli: Int = idSolicitud?.toInt() ?: 0


                                val database = "sigcon"
                                val host = "137.184.120.127"
                                val url = "jdbc:postgresql://$host/$database"
                                val usuario = "modulo4"
                                val contraseña = "modulo4"
                                try{
                                // Crear la conexión
                                    DriverManager.getConnection(url, usuario, contraseña).use { conexion ->
                                        if (conexion.isValid(5)) { // El argumento es el tiempo máximo de espera en segundos
                                            println("Conexión exitosa.")
                                            // Consulta de inserción
                                            val consultaInsercion =
                                                "insert into solicitud_cotizacion (id_solicitud_cotizacion,id_solicitud,id_personal,fecha_cotizacion,importe,id_estado) values (?,?,?,?,?,?)"

                                            // Crear una declaración preparada
                                            conexion.prepareStatement(consultaInsercion)
                                                .use { declaracionPreparada ->
                                                    // Establecer los valores de los parámetros
                                                    declaracionPreparada.setInt(1, 12545)
                                                    declaracionPreparada.setInt(2, idSoli)
                                                    declaracionPreparada.setInt(3, 1)
                                                    declaracionPreparada.setDate(
                                                        4,
                                                        Date.valueOf(LocalDate.now().toString())
                                                    )
                                                    declaracionPreparada.setDouble(5, total_importe)
                                                    declaracionPreparada.setInt(6, 1)
                                                    // Ejecutar la consulta de inserción
                                                    declaracionPreparada.executeUpdate()
                                                }
                                            println("Inserción exitosa.")
                                        } else {
                                            println("La conexión no es válida.")
                                        }
                                        }
                                }catch (ex: SQLException){
                                    println("Error en la conexión a la base de datos: ${ex.message}")
                                }
                                */

                                //OTRO INTENTO FALLIDO :,V

                                //.insertarSolicitudCotizacion(1254,idSoli,1,fechaActualString,total_importe,1)

                                //ESTE TAMBN NO SIRVE falta ARREGLAR AAA
                                sendEmail(context)

                                        viewModel.isLoading = true
                                      },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text("ACEPTAR", color = Color.White)
                        }


                    }

                }
        }else{
        CircularProgressIndicator(modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .fillMaxHeight()
            .wrapContentSize(Alignment.Center), color = Color.Gray)
        LaunchedEffect(Unit) {
            if (idSolicitud != null) {
                viewModel.cargarDataPendiente(idSolicitud)
            }
        }
    }


        },
    )
}
    private fun sendEmail(context: Context) {
        // Dirección de correo electrónico al que se enviará el correo
        val to = "triline26@gmail.com"

        // Asunto del correo electrónico
        val subject = "SOLICITUD COTIZADA - CONDOSA"

        // Cuerpo del correo electrónico
        val body = "Su solicitud fue cotizada. Revisar sección de Cotizadas y descargar PDF."

        // Crea un Intent con la acción ACTION_SENDTO
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            // Especifica la dirección de correo electrónico
            data = Uri.parse("mailto:$to")

            // Especifica el asunto y el cuerpo del correo electrónico
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }

        if (emailIntent.resolveActivity(context.packageManager) != null) {
            // Inicia la actividad del correo electrónico usando el contexto proporcionado
            context.startActivity(emailIntent)
        } else {
            showToast(context, "No hay aplicaciones de correo electrónico instaladas.")
        }
    }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }






