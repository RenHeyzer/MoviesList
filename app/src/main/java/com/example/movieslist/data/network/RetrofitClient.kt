package com.example.movieslist.data.network

import com.example.movieslist.data.network.apiservices.MovieApiService
import com.example.movieslist.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    private fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    val apiService: MovieApiService =
        getClient(Constants.BASE_URL).create(MovieApiService::class.java)
}