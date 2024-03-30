package com.example.films_viu.films

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.films_viu.R

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    fun render(filmsCategories: FilmsCategories){
        tvCategoryName.text = "EJEMPLO"

        when(filmsCategories){
            FilmsCategories.Accion -> {
                tvCategoryName.text = "Acción"
            }
            FilmsCategories.Romance -> {
                tvCategoryName.text = "Romance"
            }
            FilmsCategories.Suspenso -> {
                tvCategoryName.text = "Suspenso"
            }
        }
    }
}