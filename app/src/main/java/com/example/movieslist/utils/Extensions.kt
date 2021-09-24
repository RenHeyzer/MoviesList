package com.example.movieslist.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieslist.ui.fragments.MovieFragmentDirections

fun Fragment.open(id: Int) {
    val action = MovieFragmentDirections
        .actionMovieFragmentToMovieDetailFragment(id)
    findNavController().navigate(action)
}