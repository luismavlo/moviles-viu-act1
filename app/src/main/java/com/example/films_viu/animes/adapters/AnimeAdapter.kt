package com.example.films_viu.animes.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.films_viu.R
import com.example.films_viu.animes.models.Anime
import com.example.films_viu.animes.views.AnimeViewHolder

class AnimeAdapter(private val animesList: List<Anime>) :RecyclerView.Adapter<AnimeViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime,parent,false)
        return AnimeViewHolder(view)
    }

    override fun getItemCount()= animesList.size

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.render(animesList[position])
        val item = animesList[position]
        holder.itemView.setOnClickListener {

        }
    }

}