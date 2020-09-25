package com.example.sunbelttest.movielist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.empty_movie_list.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class MovieListViewHolder(itemView: View) : MovieListHolder(itemView) {
    var movieName: TextView
        get() = itemView.movieName
        set(value) = TODO()
    var posterImage: ImageView
        get() = itemView.posterImage
        set(value) = TODO()
    var movie: CardView
        get() = itemView.movie
        set(value) = TODO()
}

class MovieListEmptyViewHolder(itemView: View): MovieListHolder(itemView) {
    var notFoudText: TextView
        get() = itemView.notFoundText
        set(value) = TODO()
}

abstract class MovieListHolder(itemView: View): RecyclerView.ViewHolder(itemView)