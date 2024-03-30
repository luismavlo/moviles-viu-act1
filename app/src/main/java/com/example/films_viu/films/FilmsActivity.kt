package com.example.films_viu.films

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.films_viu.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

    private lateinit var fabAddFilm: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)

        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners(){
        fabAddFilm.setOnClickListener { showDialog() }
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_film)

        val btnAddFilm: Button = dialog.findViewById(R.id.btnAddFilm)
        val etFilm: EditText = dialog.findViewById(R.id.etFilm)
        val etDuration: EditText = dialog.findViewById(R.id.etDuration)
        val etImgFilm: EditText = dialog.findViewById(R.id.etImgFilm)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddFilm.setOnClickListener {
            val currentFilm = etFilm.text.toString();
            if( currentFilm.isNotEmpty() ){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: FilmsCategories = when(selectedRadioButton.text){
                    getString(R.string.action) -> FilmsCategories.Accion
                    getString(R.string.suspenso) -> FilmsCategories.Suspenso
                    getString(R.string.romance) -> FilmsCategories.Romance
                    else -> FilmsCategories.Accion
                }

                films.add(Film(etFilm.text.toString(), currentCategory, etDuration.text.toString(), etImgFilm.text.toString()))
                updateFilm()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun initComponent(){
        rvCategories = findViewById(R.id.rvCategories)
        rvFilms = findViewById(R.id.rvFilms)
        fabAddFilm = findViewById(R.id.fabAddFilm)
    }

    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories) { position -> updateCategories(position) }
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        filmAdapter = FilmAdapter(films)
        rvFilms.layoutManager = LinearLayoutManager(this)
        rvFilms.adapter = filmAdapter
    }

    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateFilm()
    }

    private fun updateFilm(){
        val selectedCategories: List<FilmsCategories> = categories.filter { it.isSelected }
        val newFilms = films.filter { selectedCategories.contains(it.category) }

        filmAdapter.films = newFilms;
        filmAdapter.notifyDataSetChanged()
    }
}