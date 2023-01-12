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

class SignIn : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    lateinit var personName : EditText
    lateinit var passWord : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = Firebase.auth
        personName = findViewById(R.id.PersonNameEditText)
        passWord = findViewById(R.id.PasswordEditText)

        val BackButtonONsignIn = findViewById<Button>(R.id.BackSignINbutton)
        BackButtonONsignIn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java )
            startActivity(intent)
        }
        val signUpButton = findViewById<Button>(R.id.SignUpbutton)
        signUpButton.setOnClickListener {
          signIn()
        }
    }
    fun signIn(){
        val personName = personName.text.toString()
        val passWord = passWord.text.toString()

        if(personName.isEmpty() || passWord.isEmpty()){
            Toast.makeText(this, "Wrong Email or Password!", Toast.LENGTH_LONG).show()
        }else{
            auth.signInWithEmailAndPassword(personName, passWord).addOnSuccessListener {
                Toast.makeText(this, "Hello User :D !", Toast.LENGTH_LONG).show()
                intent = Intent(this, holeMenu::class.java)
                startActivity(intent)
            }
        }

    }
}