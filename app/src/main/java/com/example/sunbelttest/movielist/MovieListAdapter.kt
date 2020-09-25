package com.example.sunbelttest.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Movie
import com.example.sunbelttest.R
import com.example.sunbelttest.utils.setImageFromUrl

class MovieListAdapter(private val movieList: List<Movie>, private val onItemClickListener: (Int?) -> Unit) :
    RecyclerView.Adapter<MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder =
        MovieListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movie = movieList[position]
        holder.movieName.text = movie.title.toString()
        holder.posterImage.setImageFromUrl(
            "https://image.tmdb.org/t/p/w500" + movie.posterPath,
            holder.posterImage.context
        )
        holder.movie.setOnClickListener { onItemClickListener(movie.id) }
    }

    override fun getItemCount(): Int = movieList.size
}


