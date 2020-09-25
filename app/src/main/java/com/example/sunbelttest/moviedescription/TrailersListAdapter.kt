package com.example.sunbelttest.moviedescription

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Video
import com.example.sunbelttest.R

class TrailersListAdapter(
    private val trailers: List<Video?>?,
    private val onClickListener: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_DETAILS = 1
    private val TYPE_EMPTY = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_EMPTY) {
            return EmptyTrailerListViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.empty_movie_list, parent, false)
            )
        }
        return TrailerListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.trailer_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TrailerListViewHolder) {
            val trailer = trailers?.get(position)
            trailer?.let {
                holder.trailerName.text = it.name
                holder.trailerContainer.setOnClickListener { onClickListener }
            }
        }
    }

    override fun getItemCount(): Int {
        if (trailers == null || trailers.isEmpty()) return 1
        return trailers.size
    }

    override fun getItemViewType(position: Int): Int {
        if (trailers == null || trailers.isEmpty()) {
            return TYPE_EMPTY
        }
        return TYPE_DETAILS
    }

}