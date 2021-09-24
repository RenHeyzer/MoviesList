package com.example.movieslist.ui.fragments

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieslist.base.BaseFragment
import com.example.movieslist.databinding.FragmentMovieBinding
import com.example.movieslist.interfaces.OnItemClickListener
import com.example.movieslist.ui.adapter.MovieAdapter
import com.example.movieslist.utils.open

class MovieFragment : BaseFragment<FragmentMovieBinding>(FragmentMovieBinding::inflate),
    OnItemClickListener {
    private val viewModel: MovieViewModel by activityViewModels()
    private val mAdapter = MovieAdapter(this)

    override fun initialize() {
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.movieRecycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = mAdapter
        }
    }

    override fun setupRequests() {
        viewModel.getMovies()
    }

    override fun setupObserve() {
        viewModel.movieList.observeForever {
            mAdapter.submitList(it)
        }
    }

    override fun onItemClick(id: Int) {
        open(id)
    }

}