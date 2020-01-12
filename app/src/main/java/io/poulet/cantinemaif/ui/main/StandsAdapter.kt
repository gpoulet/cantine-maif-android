package io.poulet.cantinemaif.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.poulet.cantinemaif.R
import kotlinx.android.synthetic.main.stand_item.view.*

class StandsAdapter( val stands: List<Stand>) : RecyclerView.Adapter<StandViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandViewHolder {
        return StandViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.stand_item, parent, false))
    }

    override fun getItemCount(): Int  = stands.size

    override fun onBindViewHolder(holder: StandViewHolder, position: Int) {
        val stand  = stands[position]
       holder.title.text = stand.title
       holder.meals.text = stand.meals.joinToString(separator ="\n")
    }

}


class StandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var title: TextView = itemView.title
    var meals: TextView = itemView.meals

}