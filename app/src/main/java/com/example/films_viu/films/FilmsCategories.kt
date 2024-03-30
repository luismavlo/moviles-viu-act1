package com.example.films_viu.films

sealed class FilmsCategories(var isSelected:Boolean = false) {
    object Suspenso: FilmsCategories()
    object Romance: FilmsCategories()
    object Accion: FilmsCategories()
}