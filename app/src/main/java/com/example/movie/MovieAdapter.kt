package com.example.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private var movieList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_movie, parent, false
        )
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun updateList(newList: List<Movie>) {
        movieList = newList
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        private val genreTextView: TextView = itemView.findViewById(R.id.textViewGenre)

        fun bind(movie: Movie) {
            titleTextView.text = movie.title
            genreTextView.text = movie.genre
        }
    }
}
