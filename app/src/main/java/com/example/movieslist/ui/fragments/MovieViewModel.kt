package com.example.movieslist.ui.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieslist.api.RetrofitClient
import com.example.movieslist.base.BaseViewModel
import com.example.movieslist.models.Movie
import kotlinx.coroutines.launch

class MovieViewModel : BaseViewModel() {
    var movieList = MutableLiveData<List<Movie>>()

    fun getMovies() {
        uiScope.launch {
            RetrofitClient.apiService.getMovies().let {
                if (it.isSuccessful) {
                    movieList.value = it.body()
                } else {
                    Log.e("die", "getMovies: Error ${it?.code()}")
                }
            }
        }
    }
}