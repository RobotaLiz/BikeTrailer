package com.example.bikeridesmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class Menu : AppCompatActivity() {

    lateinit var adapter: RecylerAdapter
    lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        recycler = findViewById(R.id.RecyclerView)
        adapter = RecylerAdapter(this, arrayListOf())
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this,)
        var db = Firebase.firestore
        var collection = db.collection("Places")

        collection.get().addOnSuccessListener { documentSnapShot ->
            val list = arrayListOf<AddedPlaceFromUser>()
            for (document in documentSnapShot.documents){
                val place = document.toObject<AddedPlaceFromUser>()

                if (place != null) {
                    list.add(place)
                }

            }
            adapter.setList(list)

        }

        val listBackButton = findViewById<FloatingActionButton>(R.id.ListBackButton)

        listBackButton.setOnClickListener {
            intent = Intent(this, holeMenu::class.java)
            startActivity(intent)

        }

    }
}
