package com.example.films_viu.animes.service

import android.util.Log
import com.example.films_viu.animes.models.ApiResponse.AnimeListResponse
import com.example.films_viu.animes.service.ApiAnimeService.RetrofitServiceFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
class AnimeRepository {
        suspend fun getAllAnimesFromApi(): AnimeListResponse {
            return withContext(Dispatchers.IO) {
                val apiAnimeService = RetrofitServiceFactory.getAnimesRetrofit()
                val response = apiAnimeService.getAnimes("anime?fields[anime]=canonicalTitle,averageRating,startDate,posterImage&page[number]=5&page[size]=20")
                response
            }
        }
}