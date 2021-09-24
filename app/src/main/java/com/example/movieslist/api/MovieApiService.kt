package com.example.movieslist.api

import com.example.movieslist.models.Movie
import com.example.movieslist.utils.Constants.SHOWS_END_POINT
import com.example.movieslist.utils.Constants.SHOWS_END_POINT_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiService {
    @GET(SHOWS_END_POINT)
    suspend fun getMovies(): Response<List<Movie>>

    @GET(SHOWS_END_POINT_ID)
    suspend fun getMoviesDetail(@Path("id") id: Int): Response<Movie>
}