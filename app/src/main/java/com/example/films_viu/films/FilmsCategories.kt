package com.example.films_viu.films

sealed class FilmsCategories {
    object Suspenso: FilmsCategories()
    object Romance: FilmsCategories()
    object Accion: FilmsCategories()
}