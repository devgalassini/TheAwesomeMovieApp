package com.galassinitecnology.movieapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.galassinitecnology.movieapp.R
import com.galassinitecnology.movieapp.databinding.FragmentMovieDetailBinding
import com.galassinitecnology.movieapp.utils.Constants
import com.galassinitecnology.movieapp.viewModel.movies.MovieViewModel
import org.koin.androidx.navigation.koinNavGraphViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieDetailFragment : Fragment() {

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel by koinNavGraphViewModel<MovieViewModel>(R.id.nav_main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupUI()

    }

    private fun setupUI() {
        binding.imageBackground.load(Constants.POSTER_URL_DETAIL + viewModel.moviesDetail.value?.posterPath){
            crossfade(true)
        }

        binding.imageMovie.load(Constants.POSTER_URL_VIEW + viewModel.moviesDetail.value?.posterPath){
            crossfade(true)
        }

        binding.textTitle.text = buildString {
            append(viewModel.moviesDetail.value?.title)
            append(" (${viewModel.moviesDetail.value?.releaseDate?.substring(0,4)})")
        }

        Log.e("TAG", "setupUI: ${viewModel.moviesDetail.value?.voteAverage}")
        val average = viewModel.moviesDetail.value?.voteAverage?: 0.0
        val percent = (average * 10).toInt()

        binding.circularProgressIndicator.progress = percent
        binding.textPercent.text = buildString {
            append("${percent}%")
        }

        binding.textOverview.text = viewModel.moviesDetail.value?.overview
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}