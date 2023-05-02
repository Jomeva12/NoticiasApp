package com.jomeva.noticiasapi.interfaces

import com.jomeva.noticiasapi.modelos.NoticiasResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


interface INoticias {
    @GET
  suspend  fun ontenerNoticias(@Url url:String): Response<NoticiasResponse>

    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/everything/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
       // "https://newsapi.org/v2/everything?q=tesla&from=2023-04-02&sortBy=publishedAt&apiKey=fe0a5477c0074b38ad75ada54fb268aa"
    }

}