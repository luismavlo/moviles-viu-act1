package com.example.films_viu.animes

import android.os.Bundle
import android.util.Log
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.films_viu.R
import com.example.films_viu.animes.adapters.AnimeAdapter
import com.example.films_viu.animes.models.Anime
import com.example.films_viu.animes.models.AnimeProvider
import kotlinx.coroutines.launch


class AnimesActivity : AppCompatActivity() {
    private val TAG = "AnimeActivity"
    private val getAnimes: AnimeProvider = AnimeProvider()
    private var animesApiList = mutableListOf<Anime>()
    private val animeslist= mutableListOf<Anime>(
        Anime("Shingueki No Kyoyin","https://media.kitsu.io/anime/poster_images/7442/tiny.jpg","84.84","2013-04-07"),
        Anime("Dragon Ball Super","https://media.kitsu.io/anime/poster_images/13569/tiny.jpg","81.84","2013-04-07"),
        Anime("Bleach","https://media.kitsu.io/anime/poster_images/176/tiny.jpg","80.84","2013-04-07"),
        Anime("Fullmetal Alchemist: Brotherhood","https://media.kitsu.io/anime/poster_images/3936/tiny.jpg","82.88","2013-04-07"),
        Anime("Kimetsu no Yaiba", "https://media.kitsu.io/anime/poster_images/41370/tiny.jpg","86.39","2019-04-06")
    )
    //Recycler canales
    private lateinit var rvAnimes:RecyclerView
    private lateinit var animesAdapter: AnimeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animes)
        // Lista de Animes
        rvAnimes = findViewById(R.id.rvAnimes)
        rvAnimes.layoutManager = LinearLayoutManager(this)
        animesAdapter = AnimeAdapter(animeslist)
        rvAnimes.adapter = animesAdapter
        // Probando consumo de api
        lifecycleScope.launch {
            val data = getAnimes.invoke()
            Log.i(TAG, "getAnimes.invoke ${data} recibida")
            if(data != null)
            {
                animesApiList = getAnimes.AnimeResponseAdapter(data)
                Log.i(TAG, "animesApiList ${animesApiList} recibida")
                //Borro datos del RecyclerView

                animeslist.clear()
                animeslist.addAll(animesApiList)

                Log.i(TAG, "animeAdapter ${animesAdapter} recibida")
                //animesApiList.addAll(animesApiList)
                //Repinta RecyclerView
                animesAdapter.notifyDataSetChanged()
            }
        }



    }
}