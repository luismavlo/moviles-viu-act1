package com.example.films_viu.animes.service

import com.example.films_viu.animes.models.ApiResponse.AnimeListResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

class ApiAnimeService {
    interface ApiAnimesService {
        @GET
        suspend fun getAnimes(@Url url:String) : AnimeListResponse
    }

    object RetrofitServiceFactory {
        //Funcion que crea un objeto Retrofit() a partir de una URl + una factoría de conversión + la Interfaz de la petición
        fun getAnimesRetrofit(): ApiAnimesService {
            return Retrofit.Builder()
                .baseUrl("https://kitsu.io/api/edge/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiAnimesService::class.java)
        }
    }
}