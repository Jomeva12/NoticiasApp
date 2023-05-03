package com.jomeva.noticiasapi.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jomeva.noticiasapi.R
import com.jomeva.noticiasapi.modelos.NoticiasResponse
import com.squareup.picasso.Picasso
import org.jsoup.Jsoup
import java.io.File
import java.io.FileOutputStream

class NoticiaAdapter(val noticias: NoticiasResponse?,val context: Context) :
    RecyclerView.Adapter<NoticiaAdapter.ViewHolder>() {
    private val handler = Handler(Looper.getMainLooper())
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagen = view.findViewById<ImageView>(R.id.imagenNoticia)
        val titulo = view.findViewById<TextView>(R.id.titulo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.card_notice, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int = noticias?.articles?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.titulo.text = noticias?.articles?.get(position)?.title.toString()
     /*   val thread = Thread {

           *//* val url =
                "https://www.forbes.com/sites/michaelposner/2023/05/01/national-security-advisor-sullivan-argues-for-integrating-economic-and-security-agendas/?sh=65591df0771a"
*//*val url=noticias?.articles?.get(position)?.url
            Log.d("noticiasssss3", "${url}")
           // val document = Jsoup.connect(url).get()
            val document = Jsoup.connect(url).timeout(30000).get()
            val imageUrl = document.select("meta[property=og:image]").attr("content")

            if (imageUrl != null && imageUrl.isNotEmpty()) {
                val bitmap = Picasso.get().load(imageUrl).get()

                // Guardar la imagen en un archivo temporal
                val file = File.createTempFile("webview_capture", ".png", context!!.cacheDir)
                val outputStream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                outputStream.flush()
                outputStream.close()

                // Mostrar la imagen en un ImageView, por ejemplo
                (context as Activity).runOnUiThread {
                    holder.imagen.setImageBitmap(bitmap)
                    Picasso.get().load(imageUrl).into(holder.imagen)
                }
            }

        }
        thread.start()*/

    }
}