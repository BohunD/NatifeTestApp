package com.example.natifetestapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.natifetestapp.databinding.ActivityGifBinding

class GifActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGifBinding
    private var gifUrl: String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGifBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        if(intent.hasExtra(EXTRA_URL)){
            gifUrl = intent.getStringExtra(EXTRA_URL)
            binding.ivGif.loadUrl(binding.ivGif.context, gifUrl)
        }
    }

    companion object {

        const val EXTRA_URL = "url_extra"

        fun newIntent(context: Context, url: String): Intent{
            val intent = Intent(context, GifActivity::class.java)
            intent.putExtra(EXTRA_URL, url)
            return intent
        }
    }
}