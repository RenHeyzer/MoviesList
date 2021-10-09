package com.example.movieslist.ui.fragments.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieslist.base.BaseViewModel
import com.example.movieslist.data.repositories.MovieRepository
import com.example.movieslist.models.Movie
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val repository: MovieRepository) : BaseViewModel() {
    val movie = MutableLiveData<Movie>()

    fun getMovie(id: Int) {
        uiScope.launch {
            repository.getMovieDetail(id).let {
                if (it.isSuccessful) {
                    movie.value = it.body()
                } else {
                    Log.e("die", "getMovie: Error ${it.code()}")
                }
            }
        }
    }
}