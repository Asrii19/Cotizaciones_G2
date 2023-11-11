package com.example.firstaplication.ui.views.infoSolicitudes

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.example.firstaplication.R
import com.example.firstaplication.data.model.sDataDetalle
import com.example.firstaplication.ui.views.InfoCotizaciones.DetalleCotizacionViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

fun generatePDF(context: Context, directory: File, idSolicitud: String?, viewModelCotizado:DetalleCotizacionViewModel) {

    if (idSolicitud != null) {
        val coroutineScope = viewModelCotizado.viewModelScope // Asegúrate de tener acceso al viewModelScope
        coroutineScope.launch {
            viewModelCotizado.cargarDataCotizada(idSolicitud)
            val pageHeight = 1120
            val pageWidth = 792
            val pdfDocument = PdfDocument()
            val paint = Paint()
            val title = Paint()
            val myPageInfo = PageInfo.Builder(pageWidth, pageHeight, 1).create()
            val myPage = pdfDocument.startPage(myPageInfo)
            val canvas: Canvas = myPage.canvas
            val bitmap: Bitmap? = drawableToBitmap(context.resources.getDrawable(R.drawable.group_2_icon_icons_com_63255))
            val scaleBitmap: Bitmap? = Bitmap.createScaledBitmap(bitmap!!, 120, 120, false)
            canvas.drawBitmap(scaleBitmap!!, 40f, 40f, paint)
            title.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            title.textSize = 15f
            title.color = ContextCompat.getColor(context, R.color.purple_200)
            canvas.drawText("Nombre: " + viewModelCotizado.dataDetalle.nombre, 400f, 100f, title)
            canvas.drawText("Predio: " + viewModelCotizado.dataDetalle.nombre_predio, 400f, 80f, title)
            title.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
            title.color = ContextCompat.getColor(context, R.color.purple_200)
            title.textSize = 15f
            title.textAlign = Paint.Align.CENTER
            canvas.drawText("This is sample document which we have created.", 396f, 560f, title)
            pdfDocument.finishPage(myPage)
            val file = File(directory, "Cotización_" + idSolicitud + ".pdf")

            try {
                pdfDocument.writeTo(FileOutputStream(file))
                Toast.makeText(context, "PDF file generated successfylly", Toast.LENGTH_SHORT).show()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
            pdfDocument.close()
        }
    }

}

fun drawableToBitmap(drawable: Drawable): Bitmap? {
    if (drawable is BitmapDrawable) {
        return drawable.bitmap
    }
    val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)
    return bitmap
}
