package com.example.films_viu.films

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.films_viu.R

class FilmsActivity : AppCompatActivity() {

    private val categories = listOf(
        FilmsCategories.Accion,
        FilmsCategories.Romance,
        FilmsCategories.Suspenso
    )

    private val films = mutableListOf(
        Film("Detectives de la mente", FilmsCategories.Suspenso, "2 horas", "https://m.media-amazon.com/images/S/pv-target-images/180c7d5fa90d026b5a150213f3598fe3b58fd6145e95e16d620fae34c9ee71c2.jpg"),
        Film("Batman", FilmsCategories.Accion, "4 horas", "https://i.blogs.es/0c9485/the-batman-cartel/840_560.jpeg"),
        Film("Paseo por las nubes", FilmsCategories.Romance, "1 hora 30 minutos", "https://pics.filmaffinity.com/Un_paseo_por_las_nubes-243656334-large.jpg")
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvFilms: RecyclerView
    private lateinit var filmAdapter: FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)

        initComponent()
        initUI()
    }

    private fun initComponent(){
        rvCategories = findViewById(R.id.rvCategories)
        rvFilms = findViewById(R.id.rvFilms)
    }

    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        filmAdapter = FilmAdapter(films)
        rvFilms.layoutManager = LinearLayoutManager(this)
        rvFilms.adapter = filmAdapter
    }
}