package com.example.films_viu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.films_viu.films.FilmsActivity
import com.example.films_viu.animes.AnimesActivity
class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnFilmsPage = findViewById<Button>(R.id.btnFilms)
        btnFilmsPage.setOnClickListener { navigateToFilmsPage() }

        val btnAnimesPage = findViewById<Button>(R.id.btnAnimes)
        btnAnimesPage.setOnClickListener { navigateToAnimesPage() }
    }

    fun navigateToFilmsPage() {
        val intent = Intent(this, FilmsActivity::class.java)
        startActivity(intent)
    }

    fun navigateToAnimesPage() {
        val intent1 = Intent(this,AnimesActivity::class.java)
        startActivity(intent1)
    }
}