package com.example.movieslist.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel() {
    val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main.plus(job))
}