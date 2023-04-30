package ru.anb.fitnesskit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.anb.fitnesskit.api.ApiService

class MainViewModelFactory constructor(
    private val retrofit: ApiService
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelTraining::class.java)) {
            return ViewModelTraining(retrofit) as T
        }
        throw java.lang.IllegalArgumentException("Unknown class name")
    }
}