package com.example.bikeridesmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signInButton = findViewById<Button>(R.id.SignInbutton)


        signInButton.setOnClickListener {
            val intent = Intent(this, SignIn::class.java )
            startActivity(intent)
        }
        val regButton = findViewById<Button>(R.id.Registerbutton)

        regButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }


        }
    }



