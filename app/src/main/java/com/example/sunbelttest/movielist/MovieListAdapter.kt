package com.example.sunbelttest.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Movie
import com.example.persistence.utils.IMAGE_API_BASE_URL
import com.example.sunbelttest.R
import com.example.sunbelttest.utils.setImageFromUrl

class MovieListAdapter(
    private val movieList: List<Movie>,
    private val onItemClickListener: (Movie) -> Unit
) :
    RecyclerView.Adapter<MovieListHolder>() {

    private val EMPTY_VIEW = 0
    private val LIST_VIEW = 1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListHolder {
        if (viewType == EMPTY_VIEW) {
            return MovieListEmptyViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.empty_movie_list, parent, false)
            )
        }
        return MovieListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieListHolder, position: Int) {
        if (holder is MovieListViewHolder) {
            val movie = movieList[position]
            holder.movieName.text = movie.title.toString()
            holder.posterImage.setImageFromUrl(
                IMAGE_API_BASE_URL + movie.posterPath,
                holder.posterImage.context
            )
            holder.movie.setOnClickListener { onItemClickListener(movie) }
        }
    }

    override fun getItemCount(): Int {
        if (movieList.isEmpty()) return 1
        return movieList.size
    }

    override fun getItemViewType(position: Int): Int {
        if (movieList.isEmpty()) {
            return EMPTY_VIEW
        }
        return LIST_VIEW
    }
}


