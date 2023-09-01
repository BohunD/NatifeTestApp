package com.example.natifetestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.natifetestapp.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GifsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val apiService = createGiphyApiService()
        val gifRepository = GifRepository(apiService)
        val viewModelFactory = GifViewModelFactory(gifRepository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(GifsViewModel::class.java)

        val adapter = GifsAdapter { gifUrl ->
            val intent = GifActivity.newIntent(this, gifUrl)
            startActivity(intent)
        }
        binding.rvGifs.adapter = adapter

        viewModel.gifs.observe(this) { gifs ->
            adapter.submitList(gifs)
        }

        viewModel.getTrendingGifs()
    }

    private fun createGiphyApiService(): GifsApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.giphy.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(GifsApiService::class.java)
    }
}