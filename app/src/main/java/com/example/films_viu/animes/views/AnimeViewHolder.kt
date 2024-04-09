package com.example.films_viu.animes.views

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.films_viu.R
import com.example.films_viu.animes.models.Anime
import com.squareup.picasso.Picasso

class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imgAnime: ImageView = view.findViewById(R.id.imagenAnime)
    private val txtTituloAnime: TextView = view.findViewById(R.id.txtTituloAnime)
    private val txtAvgRating: TextView = view.findViewById(R.id.txtAverageRating)
    private val txtStrDate: TextView = view.findViewById(R.id.txtStartDate)
    fun render(anime: Anime) {
        txtTituloAnime.text = anime.titulo
        txtAvgRating.text = anime.avgRating
        txtStrDate.text = anime.start
        Picasso.get().load(anime.imgSrc).into(imgAnime)
    }
}