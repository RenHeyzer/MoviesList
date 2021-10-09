package com.example.movieslist.ui.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieslist.base.BaseViewModel
import com.example.movieslist.data.repositories.MovieRepository
import com.example.movieslist.models.Movie
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : BaseViewModel() {
    var movieList = MutableLiveData<List<Movie>>()

    init {
        getMovies()
    }

    private fun getMovies() {
        uiScope.launch {
            repository.getMovies().let {
                if (it.isSuccessful) {
                    movieList.value = it.body()
                } else {
                    Log.e("die", "getMovies: Error ${it.code()}")
                }
            }
        }
    }
}