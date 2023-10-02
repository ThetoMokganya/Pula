package com.illinodes.pula.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.illinodes.pula.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listeners()
    }

    fun listeners(){
        val mapFab = findViewById<FloatingActionButton>(R.id.map_fab)
        mapFab.setOnClickListener{
            intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }
}