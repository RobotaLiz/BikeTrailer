package com.example.bikeridesmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.Button

class holeMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hole_menu)

        val listOfTrailsButton = findViewById<Button>(R.id.ListOfTrailsbutton)
        listOfTrailsButton.setOnClickListener {
            intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
        val addTrailsButton = findViewById<Button>(R.id.AddTrailsbutton)
        addTrailsButton.setOnClickListener {
            val intent = Intent(this, AddTrails::class.java)
            startActivity(intent)

        }
        val LogOutButton = findViewById<Button>(R.id.LogOutbutton)

        LogOutButton.setOnClickListener {
            intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }
        val holeMapActionButton = findViewById<Button>(R.id.HoleMapActionButton)

        holeMapActionButton.setOnClickListener {

        }
    }
}
