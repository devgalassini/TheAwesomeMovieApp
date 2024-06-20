package com.galassinitecnology.movieapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.galassinitecnology.movieapp.api.model.response.movies.Movie
import com.galassinitecnology.movieapp.ui.fragments.DefaultViewPagerFragment

class ViewPagerAutoAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private var items: List<Movie> = emptyList()

    fun setItems(newItems: List<Movie>) {
        items = newItems
        notifyItemRangeInserted(0, items.size)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return DefaultViewPagerFragment.newInstance(items[position])
    }
}