package com.example.movieslist.ui.fragments

import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieslist.base.BaseFragment
import com.example.movieslist.databinding.FragmentMovieBinding
import com.example.movieslist.interfaces.OnItemClickListener
import com.example.movieslist.ui.adapter.MovieAdapter
import com.example.movieslist.utils.open
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : BaseFragment<FragmentMovieBinding>(FragmentMovieBinding::inflate),
    OnItemClickListener {
    private val viewModel: MovieViewModel by viewModel()
    private val mAdapter = MovieAdapter(this@MovieFragment)

    override fun initialize() {
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.movieRecycler.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = mAdapter
        }
    }

    override fun setupObserve() {
        viewModel.movieList.observe(viewLifecycleOwner, {
            mAdapter.submitList(it)
        })
    }

    override fun onItemClick(id: Int) {
        open(id)
    }
}