package com.example.sunbelttest.moviedescription

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.trailer_item.view.*

class TrailerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var trailerName: TextView
        get() = itemView.trailerName
        set(value) = TODO()
    var trailerContainer: CardView
        get() = itemView.trailer
        set(value) = TODO()
}