package com.example.movieslist.ui.fragments.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.movieslist.base.BaseFragment
import com.example.movieslist.databinding.FragmentDetailMovieBinding

class MovieDetailFragment :
    BaseFragment<FragmentDetailMovieBinding>(FragmentDetailMovieBinding::inflate) {
    private val viewModel: MovieDetailViewModel by viewModels()
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun setupRequests() {
        viewModel.getMovie(args.id)
    }

    override fun setupObserve() {
        viewModel.movie.observeForever {
            binding.title.text = it.name
            binding.detailImage.load(it.image.original) {
                crossfade(true)
                crossfade(1000)
            }
            binding.type.text = it.type
            binding.status.text = it.status
            binding.rating.text = it.rating.toString()
            binding.language.text = it.language
            binding.premiered.text = it.premiered
            binding.ended.text = it.ended
            binding.runtime.text = it.runtime.toString()
            binding.description.text = it.summary
            binding.genres.text = it.genres.toString()
        }
    }
}