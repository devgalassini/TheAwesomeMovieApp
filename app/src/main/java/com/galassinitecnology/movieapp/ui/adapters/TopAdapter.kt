package com.galassinitecnology.movieapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.galassinitecnology.movieapp.api.model.response.movies.Movie
import com.galassinitecnology.movieapp.databinding.ViewPagerItemMovieBinding
import com.galassinitecnology.movieapp.utils.Constants

class TopAdapter(
    private val onClick: (Movie) -> Unit
): RecyclerView.Adapter<TopAdapter.ViewHolder>() {

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
        private val binding: ViewPagerItemMovieBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie){
            binding.imagePoster.load(Constants.POSTER_URL_VIEW + movie.posterPath)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewPagerItemMovieBinding.inflate(
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