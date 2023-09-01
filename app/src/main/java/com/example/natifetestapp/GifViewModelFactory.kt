package com.example.natifetestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GifViewModelFactory(private val gifRepository: GifRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GifsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GifsViewModel(gifRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
