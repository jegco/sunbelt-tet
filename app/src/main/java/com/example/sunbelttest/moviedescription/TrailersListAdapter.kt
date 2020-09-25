package com.example.sunbelttest.moviedescription

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Video
import com.example.sunbelttest.R

class TrailersListAdapter(
    private val trailers: List<Video?>,
    private val onClickListener: (String) -> Unit
) :
    RecyclerView.Adapter<TrailerListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerListViewHolder =
        TrailerListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.trailer_item, parent, false)
        )

    override fun onBindViewHolder(holder: TrailerListViewHolder, position: Int) {
        val trailer = trailers[position]
        trailer?.let {
            holder.trailerName.text = it.name
            holder.trailerContainer.setOnClickListener { onClickListener }
        }
    }

    override fun getItemCount(): Int = trailers.size

}