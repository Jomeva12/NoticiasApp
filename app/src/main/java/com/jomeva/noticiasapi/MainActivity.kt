package com.jomeva.noticiasapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jomeva.noticiasapi.interfaces.INoticias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //fe0a5477c0074b38ad75ada54fb268aa
        getNoticias()
    }
    fun getNoticias(){
      CoroutineScope(Dispatchers.IO).launch {
          val call=INoticias.retrofit.create(INoticias::class.java).ontenerNoticias("?q=tesla&from=2023-04-02&sortBy=publishedAt&apiKey=fe0a5477c0074b38ad75ada54fb268aa")
          val noticias=call.body()
          if (call.isSuccessful){
              Log.d("noticias","$noticias")
          }else{

          }

          runOnUiThread{
              // "https://newsapi.org/v2/everything?q=tesla&from=2023-04-02&sortBy=publishedAt&apiKey=fe0a5477c0074b38ad75ada54fb268aa"

          }
      }
    }
}