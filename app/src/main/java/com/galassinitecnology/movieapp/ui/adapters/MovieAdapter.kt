package com.galassinitecnology.movieapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import com.galassinitecnology.movieapp.R

import com.galassinitecnology.movieapp.api.model.response.movies.Movie
import com.galassinitecnology.movieapp.api.model.type.MovieType
import com.galassinitecnology.movieapp.databinding.ItemMovieBinding
import com.galassinitecnology.movieapp.utils.Constants

class MovieAdapter(
    private val onClick: (Int, MovieType) -> Unit,
    private val type: MovieType
): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movieList: AsyncListDiffer<Movie> = AsyncListDiffer(this, DiffCallBack)

    fun updateList(list: List<Movie>){
        movieList.submitList(list)
    }

    object DiffCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(
        private val binding: ItemMovieBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie){
            Log.e("TAG", "bind: ${Constants.POSTER_URL + movie.posterPath}" )
            binding.imageMovie.load(Constants.POSTER_URL + movie.posterPath) {
                diskCachePolicy(CachePolicy.ENABLED)
                error(R.drawable.ic_image_not)
            }
            binding.textTitle.text = movie.title

            binding.root.setOnClickListener {
                onClick(bindingAdapterPosition, type)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList.currentList[position])
    }
}