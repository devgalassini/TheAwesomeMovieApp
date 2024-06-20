package com.galassinitecnology.movieapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.galassinitecnology.movieapp.api.model.response.movies.Movie

class ViewPagerMovieAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle, private val movies: List<Movie>): FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun createFragment(position: Int): Fragment {

        movies.forEach {
//            return TopMovieFragment(it)
        }

        return Fragment()
    }
}