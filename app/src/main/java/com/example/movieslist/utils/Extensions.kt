package com.example.movieslist.utils

import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import coil.size.Scale
import com.example.movieslist.ui.fragments.MovieFragmentDirections

fun Fragment.open(id: Int) {
    val action = MovieFragmentDirections
        .actionMovieFragmentToMovieDetailFragment(id)
    findNavController().navigate(action)
}

fun ImageView.loadImage(img: String) {
    load(img) {
        crossfade(true)
        crossfade(1000)
        scale(Scale.FIT)
    }
}
