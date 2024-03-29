package com.example.films_viu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.films_viu.films.FilmsActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnFilmsPage = findViewById<Button>(R.id.btnFilms)
        btnFilmsPage.setOnClickListener { navigateToFilmsPage() }
    }

    fun navigateToFilmsPage() {
        val intent = Intent(this, FilmsActivity::class.java)
        startActivity(intent)
    }
}