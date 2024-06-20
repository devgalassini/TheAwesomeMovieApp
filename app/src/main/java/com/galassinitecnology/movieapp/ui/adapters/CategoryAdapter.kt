package com.galassinitecnology.movieapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.galassinitecnology.movieapp.api.model.response.categories.Genre
import com.galassinitecnology.movieapp.databinding.ItemCategoriesBinding


class CategoryAdapter(
    private val onClick: (Genre) -> Unit
): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var genreList: AsyncListDiffer<Genre> = AsyncListDiffer(this, DiffCallBack)

    fun updateList(list: List<Genre>){
        genreList.submitList(list)
    }

    object DiffCallBack : DiffUtil.ItemCallback<Genre>() {
        override fun areItemsTheSame(
            oldItem: Genre,
            newItem: Genre
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Genre,
            newItem: Genre
        ): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(
        private val binding: ItemCategoriesBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(genre: Genre){
            binding.textName.text = genre.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return genreList.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(genreList.currentList[position])
    }
}