package com.example.movieslist.data.repositories

import com.example.movieslist.data.network.apiservices.MovieApiService

class MovieRepository(private val apiService: MovieApiService) {
    suspend fun getMovies() = apiService.getMovies()
    suspend fun getMovieDetail(id: Int) = apiService.getMoviesDetail(id)

}