package com.jomeva.noticiasapi

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jomeva.noticiasapi.adapter.NoticiaAdapter
import com.jomeva.noticiasapi.interfaces.INoticias
import com.jomeva.noticiasapi.modelos.NoticiasResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //fe0a5477c0074b38ad75ada54fb268aa
        val fechaActual = LocalDate.now()
        val formatter = DateTimeFormatter.ISO_DATE
        val fechaActualEnFormatoISO = fechaActual.format(formatter)

        Log.d("fechaActualEnFormatoISO","$fechaActualEnFormatoISO")
        getNoticias(fechaActual)
    }
    fun getNoticias(fechaActual: LocalDate) {
      CoroutineScope(Dispatchers.IO).launch {
          val call=INoticias.retrofit.create(INoticias::class.java).ontenerNoticias("?q=tesla&from=$fechaActual&sortBy=publishedAt&apiKey=fe0a5477c0074b38ad75ada54fb268aa")
          val noticias=call.body()
val noti=noticias

          runOnUiThread{
              if (call.isSuccessful){
                  initRecycler(noti)
                  Log.d("noticiasssss","$noticias")
              }else{

              }


          }
      }
    }
    fun initRecycler(noticias: NoticiasResponse?) {
        val recicler=findViewById<RecyclerView>(R.id.recicler)
        recicler.layoutManager=LinearLayoutManager(this)
        val mAdapter=NoticiaAdapter(noticias)
        recicler.adapter=mAdapter
    }

}