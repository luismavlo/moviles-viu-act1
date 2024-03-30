package com.example.films_viu.films

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.films_viu.R

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val viewContainerFilm: CardView = view.findViewById(R.id.viewContainerFilm)
    fun render(filmsCategories: FilmsCategories, onItemSelected: (Int) -> Unit){

        val color = if (filmsCategories.isSelected){
            R.color.background_card
        }else {
            R.color.background_disabled
        }

        viewContainerFilm.setCardBackgroundColor(ContextCompat.getColor(viewContainerFilm.context, color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

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