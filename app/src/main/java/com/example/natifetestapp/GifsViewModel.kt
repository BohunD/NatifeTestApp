package com.example.natifetestapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class GifsViewModel(private val gifRepository: GifRepository) : ViewModel() {

    private val _gifs = MutableLiveData<List<GifItem>>()
    val gifs: LiveData<List<GifItem>> = _gifs

    fun getTrendingGifs() {
        viewModelScope.launch {
            val apiKey = "bgHxuE8qKgNoX6RBuLrDY3F4qeKt0iaX"
            val limit = 25
            val offset = 0
            val rating = "g"
            val bundle = "messaging_non_clips"

            val gifs = gifRepository.getTrendingGifs(apiKey, limit, offset, rating, bundle)
            _gifs.value = gifs
        }
    }
}