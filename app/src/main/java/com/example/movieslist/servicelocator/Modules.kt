package com.example.movieslist.servicelocator

import com.example.movieslist.data.network.RetrofitClient
import com.example.movieslist.data.repositories.MovieRepository
import com.example.movieslist.ui.fragments.MovieViewModel
import com.example.movieslist.ui.fragments.detail.MovieDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}

val repositoriesModule = module {
    factory { MovieRepository(get()) }
}

val networkModule = module {
    single { RetrofitClient }
    single { get<RetrofitClient>().apiService }
}