package com.galassinitecnology.movieapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.galassinitecnology.movieapp.R
import com.galassinitecnology.movieapp.api.model.request.MovieRequest
import com.galassinitecnology.movieapp.api.model.response.categories.Genre
import com.galassinitecnology.movieapp.api.model.type.MovieType
import com.galassinitecnology.movieapp.databinding.FragmentHomeBinding
import com.galassinitecnology.movieapp.extensions.showSnackBarRed
import com.galassinitecnology.movieapp.ui.adapters.CategoryAdapter
import com.galassinitecnology.movieapp.ui.adapters.MovieAdapter
import com.galassinitecnology.movieapp.ui.adapters.ViewPagerAutoAdapter
import com.galassinitecnology.movieapp.viewModel.movies.MovieViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.navigation.koinNavGraphViewModel

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by koinNavGraphViewModel<MovieViewModel>(R.id.nav_main)

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var playingAdapter: MovieAdapter
    private lateinit var popularAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()

        setupObserver()

        viewModel.getCategories()

        viewModel.getMoviesPlaying(
            MovieRequest(
                certificationCountry = "BR",
                releaseDateGte = "2023-10-18",
                releaseDateLte = "2023-11-29",
                sortBy = "popularity.desc",
                showMe = 0,
                voteAverageGte = 0,
                voteAverageLte = 10,
                voteCountGte = 0,
                watchRegion = "BR",
                withReleaseType = 3,
                withRuntimeGte = 0,
                withRuntimeLte = 400
            )
        )

        viewModel.getMoviesPopular(
            MovieRequest()
        )

        viewModel.getMoviesTop(
            MovieRequest(
                certificationCountry = "BR",
                releaseDateLte = "2024-05-28",
                showMe = 0,
                sortBy = "vote_average.desc",
                voteAverageGte = 0,
                voteAverageLte = 10,
                voteCountGte = 300,
                watchRegion = "BR",
                withRuntimeGte = 0,
                withRuntimeLte = 400
            )
        )
    }

    private fun setupObserver(){
        viewModel.categories.observe(viewLifecycleOwner){
            categoryAdapter.updateList(it.genres)
        }

        viewModel.moviesPlaying.observe(viewLifecycleOwner){
            it?.let {
                playingAdapter.updateList(it)
            }
        }

        viewModel.moviesPopular.observe(viewLifecycleOwner){
            it?.let {
                popularAdapter.updateList(it)
            }
        }

        viewModel.moviesTop.observe(viewLifecycleOwner){

            val topAdapter = ViewPagerAutoAdapter(childFragmentManager, lifecycle)

            binding.viewPagerList.apply {
                adapter = topAdapter
            }

            TabLayoutMediator(binding.tabLayoutList, binding.viewPagerList){ _, _-> }.attach()
            it?.let {
                topAdapter.setItems(it.subList(0,5))
            }


        }

        viewModel.navigationToDetailsLiveData.observe(viewLifecycleOwner){
            it.getContentIfNotHandled()?.let {
                findNavController()
                    .navigate(
                        HomeFragmentDirections
                            .actionHomeFragmentToMovieDetailFragment()
                    )

            }
        }

        viewModel.error.observe(viewLifecycleOwner){
            binding.root.showSnackBarRed(it)
        }
    }

    private fun setupRecycler() {

        categoryAdapter = CategoryAdapter(::onClickCategory)

        binding.recyclerCategories.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }

        playingAdapter = MovieAdapter(::onClickMovie, MovieType.PLAYING)

        binding.recyclerPlaying.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = playingAdapter
        }

        popularAdapter = MovieAdapter(::onClickMovie, MovieType.POPULAR)

        binding.recyclerPopular.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = popularAdapter
        }
    }

    private fun onClickMovie(position: Int, type: MovieType){
        Log.e("Movie", "Clicked")
        viewModel.onMovieSelected(position, type)
    }

    private fun onClickCategory(genre: Genre){

    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}