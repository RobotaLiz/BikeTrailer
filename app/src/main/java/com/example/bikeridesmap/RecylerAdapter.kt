package com.example.bikeridesmap

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecylerAdapter(val context : Context,val list : MutableList<AddedPlaceFromUser>) : RecyclerView.Adapter<RecylerAdapter.viewHolder>() {



    val inflater = LayoutInflater.from(context)

    // den som håller i item_in_xml alltså de menas med en hel rutan i listan.
    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView = itemView.findViewById<TextView>(R.id.nametextView)
        val lengthTextView = itemView.findViewById<TextView>(R.id.lengthView)
        val difficultyTextView = itemView.findViewById<TextView>(R.id.difficultyView)
        val mapButton = itemView.findViewById<ImageButton>(R.id.mapItemButton)

    }

    // åter använder den gamla item_in_list alltså det menas med att den återanvänder rutorna i listan.
    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val addedPlace = list[position]

        holder.nameTextView.text = addedPlace.name
        holder.lengthTextView.text = addedPlace.length.toString()
        holder.difficultyTextView.text = addedPlace.difficulty.toString()
        holder.mapButton.setOnClickListener {

        }


    }

    // här skapas nya item_in_list det menas med att den skapar en ny ruta i listan.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = inflater.inflate(R.layout.item_in_list, parent, false)
        return viewHolder(itemView)
    }

    // den räknar alla rutor i en lista.
    override fun getItemCount() = list.size

    // sätter listan för recycler Adaptern.
    fun setList(newList: MutableList<AddedPlaceFromUser>){
        list.clear()
        for (place in newList ){
            list.add(place)

        }
        notifyDataSetChanged()
    }



}
