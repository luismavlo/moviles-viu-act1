package com.example.films_viu.animes.models

import com.example.films_viu.animes.models.ApiResponse.AnimeListResponse
import com.example.films_viu.animes.service.AnimeRepository

class AnimeProvider {
        private val repository : AnimeRepository = AnimeRepository()
        suspend operator fun invoke():AnimeListResponse {
            val animes = repository.getAllAnimesFromApi()
            return animes
        }
        fun AnimeResponseAdapter(AnimeListResponse:AnimeListResponse): MutableList<Anime>{
            val animeAdapter : MutableList<Anime> = arrayListOf()
            for(doc in AnimeListResponse.data){
                animeAdapter.add(
                    Anime(doc.attributes.canonicalTitle,doc.attributes.posterImage.tiny, doc.attributes.averageRating,doc.attributes.startDate))
            }
            return animeAdapter
        }
}