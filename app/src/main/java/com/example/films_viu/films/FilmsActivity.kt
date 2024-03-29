package com.example.films_viu.films

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.films_viu.R

class FilmsActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)

        initComponent()
        initUI()
    }

    private fun initComponent(){
        rvCategories = findViewById(R.id.rvCategories)
    }

    private fun initUI(){

    }
}