package com.jomeva.noticiasapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.jomeva.noticiasapi.R
import com.jomeva.noticiasapi.modelos.NoticiasResponse
import com.squareup.picasso.Picasso

class NoticiaAdapter(val noticias: NoticiasResponse?):RecyclerView.Adapter<NoticiaAdapter.ViewHolder>() {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
val imagen=view.findViewById<ImageView>(R.id.imagenNoticia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layout=LayoutInflater.from(parent.context).inflate(R.layout.card_notice,parent,false)
      return  ViewHolder(layout)
    }

    override fun getItemCount(): Int = noticias?.articles?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
Picasso.get().load(noticias?.articles?.get(position)?.url).into(holder.imagen)
    }
}