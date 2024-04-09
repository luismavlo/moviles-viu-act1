package com.example.films_viu.animes.models

enum class CategoriasAnimes {
     ADVENTURE, FANTASY, ACTION, FICTION
}
data class Anime (var titulo: String, var imgSrc: String, var avgRating: String, var start: String, var categoria: CategoriasAnimes, var isSelected: Boolean= false)