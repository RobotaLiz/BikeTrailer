package com.example.bikeridesmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.net.Inet4Address

class Register : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    lateinit var regNameEditText: EditText
    lateinit var regEmailEditText: EditText
    lateinit var regPassWordEditText: EditText
    lateinit var regAddressEditText : EditText
    lateinit var regDateEditText: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        regEmailEditText = findViewById(R.id.RegEmailAddressEditText)
        regPassWordEditText = findViewById(R.id.RegPasswordEditText)

        auth = Firebase.auth

        val regMenuButton = findViewById<Button>(R.id.RegMenubutton)

        regMenuButton.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val acceptButton = findViewById<Button>(R.id.Acceptbutton)
        acceptButton.setOnClickListener {
            acceptAndReg()
        }

    }
    fun acceptAndReg(){
        val regEmail = regEmailEditText.text.toString()
        val regPassWord = regPassWordEditText.text.toString()

        if(regEmail.isEmpty()||regPassWord.isEmpty()){
            Toast.makeText(this, "Email and Password required!", Toast.LENGTH_LONG).show()
        }else{
            auth.createUserWithEmailAndPassword(regEmail, regPassWord).addOnSuccessListener {
                Toast.makeText(this, "Welcome To this BikeTrail app!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, holeMenu::class.java)
                startActivity(intent)
            }
        }
    }
}
