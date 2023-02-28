package com.example.bikeridesmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.checkerframework.checker.units.qual.Length

class AddTrails : AppCompatActivity() {
    lateinit var db : FirebaseFirestore
    lateinit var auth: FirebaseAuth
    lateinit var addedNameTrails : EditText
    lateinit var addLength: EditText
    lateinit var difficulty : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_trails)

        auth = Firebase.auth
        db = Firebase.firestore

        addedNameTrails = findViewById(R.id.AddnameOfTheTrailEditText)
        addLength = findViewById(R.id.AddLengthEditText)
        difficulty = findViewById(R.id.AddDifficultyEditText)

        val finish = findViewById<Button>(R.id.AddFinishbutton)
        finish.setOnClickListener {
            val place = AddedPlaceFromUser(
                name = addedNameTrails.text.toString(),
                length = addLength.text.toString().toDouble(),
                difficulty = difficulty.text.toString().toDouble() )
            if(auth.currentUser == null){
                Toast.makeText(this, "Sign in required!", Toast.LENGTH_LONG).show()
            }else{
                var collection = db.collection("Places")
                collection.add(place)
                    .addOnSuccessListener {
                        Toast.makeText(this, "You added a new trail!", Toast.LENGTH_LONG).show()
                       val intent = Intent(this, holeMenu::class.java)
                        startActivity(intent)
                    }.addOnFailureListener { bajs ->  Log.d("!!!", bajs.toString())}
            }

        }

        val goBack = findViewById<Button>(R.id.AddGoBackbutton)

        goBack.setOnClickListener {
            val intent = Intent(this, holeMenu::class.java)
            startActivity(intent)
        }

    }
}