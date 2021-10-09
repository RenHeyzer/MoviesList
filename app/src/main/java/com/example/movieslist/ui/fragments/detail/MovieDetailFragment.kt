package com.example.movieslist.ui.fragments.detail

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.movieslist.base.BaseFragment
import com.example.movieslist.databinding.FragmentDetailMovieBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MovieDetailFragment :
    BaseFragment<FragmentDetailMovieBinding>(FragmentDetailMovieBinding::inflate) {
    private val viewModel: MovieDetailViewModel by viewModel()
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun setupRequests() {
        viewModel.getMovie(args.id)
    }

    override fun setupObserve() {
        viewModel.movie.observeForever {
            binding.title.text = it.name
            binding.detailImage.load(it.image.original)
            binding.type.text = it.type
            binding.status.text = it.status
            binding.rating.text = it.rating.average.toString()
            binding.language.text = it.language
            binding.premiered.text = it.premiered
            binding.ended.text = it.ended
            binding.runtime.text = it.runtime.toString()
            binding.description.text = it.summary.replace("<", "")
                .replace("/", "").replace(">", "")
                .removePrefix("p").removePrefix("b").removeSuffix("p")
            binding.genres.text = it.genres.toString().removePrefix("[")
                .removeSuffix("]").replace(",", " ")

        }
    }

}