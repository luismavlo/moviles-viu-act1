package com.example.films_viu.films

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.films_viu.R
import com.squareup.picasso.Picasso


class FilmViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvDurationFilm: TextView = view.findViewById(R.id.tvDurationFilm)
    private val tvTitleFilm: TextView = view.findViewById(R.id.tvTitleFilm)
    private val imFilmImg: ImageView = view.findViewById(R.id.imFilmImg)

    fun render(film: Film){
        tvTitleFilm.text = film.name
        tvDurationFilm.text = film.duration
        Picasso.get().load(film.imgFilm).into(imFilmImg)
    }

}