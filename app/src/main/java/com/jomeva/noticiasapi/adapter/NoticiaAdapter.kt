package com.jomeva.noticiasapi.adapter

import android.content.Intent
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

class NoticiaAdapter(val noticias: NoticiasResponse?):RecyclerView.Adapter<NoticiaAdapter.ViewHolder>() {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
val imagen=view.findViewById<ImageView>(R.id.imagenNoticia)
        val titulo=view.findViewById<TextView>(R.id.titulo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layout=LayoutInflater.from(parent.context).inflate(R.layout.card_notice,parent,false)
      return  ViewHolder(layout)
    }

    override fun getItemCount(): Int = noticias?.articles?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titulo.text=noticias?.articles?.get(position)?.title.toString()
       // val url=noticias?.articles?.get(position)?.url

       /* val thread=Thread{
            val url = "https://www.forbes.com/sites/michaelposner/2023/05/01/national-security-advisor-sullivan-argues-for-integrating-economic-and-security-agendas/?sh=65591df0771a"

            val document = Jsoup.connect(url).get()

            val imageUrl = document.select("meta[property=og:image]").attr("content")


            Log.d("noticiasssss2","${noticias?.articles?.get(position)?.url}")
            Picasso.get().load(imageUrl).into(holder.imagen)
        }*/

    }
}