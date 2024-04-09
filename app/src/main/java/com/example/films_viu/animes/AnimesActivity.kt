package com.example.films_viu.animes

import android.os.Bundle
import android.util.Log
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.films_viu.R
import com.example.films_viu.animes.adapters.AnimeAdapter
import com.example.films_viu.animes.models.Anime
import com.example.films_viu.animes.models.CategoriasAnimes

class AnimesActivity : AppCompatActivity() {
    private val TAG = "AnimeActivity"
    private val animeslist= listOf(
        Anime("Shingueki No Kyoyin","https://media.kitsu.io/anime/poster_images/7442/tiny.jpg","84.84","2013-04-07",CategoriasAnimes.ADVENTURE,false),
        Anime("Dragon Ball Super","https://media.kitsu.io/anime/poster_images/13569/tiny.jpg","81.84","2013-04-07",CategoriasAnimes.FANTASY,false),
        Anime("Bleach","https://media.kitsu.io/anime/poster_images/176/tiny.jpg","80.84","2013-04-07",CategoriasAnimes.ADVENTURE,true),
        Anime("Fullmetal Alchemist: Brotherhood","https://media.kitsu.io/anime/poster_images/3936/tiny.jpg","82.88","2013-04-07",CategoriasAnimes.ACTION,false),
        Anime("Kimetsu no Yaiba", "https://media.kitsu.io/anime/poster_images/41370/tiny.jpg","86.39","2019-04-06",CategoriasAnimes.ADVENTURE,false)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animes)
        // Lista de Animes

        val rvAnimes: RecyclerView = findViewById(R.id.rvAnimes)
        val animeAdapter = AnimeAdapter(animeslist)

        rvAnimes.layoutManager = LinearLayoutManager(this)
        rvAnimes.adapter = animeAdapter
        Log.i(TAG, "animeAdapter ${animeAdapter} recibida")
    }
}