package com.galassinitecnology.movieapp.ui.fragments

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.galassinitecnology.movieapp.databinding.FragmentSplashBinding
import com.galassinitecnology.movieapp.ui.activities.MainActivity


class SplashFragment : Fragment() {

    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDelay()
    }

    private fun initDelay() {
        val progressBarHorizontal = binding.progressBar

        val totalProgressTime = 3000
        val progressBarMax = 100

        val animator = ValueAnimator.ofInt(0, progressBarMax)
        animator.duration = totalProgressTime.toLong()

        animator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            progressBarHorizontal.progress = progress
        }

        animator.start()

        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                startActivity(Intent(requireContext(), MainActivity::class.java))
                requireActivity().finishAffinity()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}