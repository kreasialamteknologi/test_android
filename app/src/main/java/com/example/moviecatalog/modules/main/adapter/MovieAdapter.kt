package com.example.moviecatalog.modules.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecatalog.R
import com.example.moviecatalog.databinding.ItemMovieBinding
import com.example.moviecatalog.models.Movie
import com.example.moviecatalog.utils.setLayoutBinding

class MovieAdapter(private var list: List<Movie> = listOf()) :
    RecyclerView.Adapter<MovieAdapter.MovieVH>() {

    private lateinit var binding: ItemMovieBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        binding = parent.setLayoutBinding(R.layout.item_movie, parent)
        return MovieVH(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        holder.bind(list[position])
    }

    inner class MovieVH(binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun bind (movie: Movie){
            binding.imageUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
        }
    }
}