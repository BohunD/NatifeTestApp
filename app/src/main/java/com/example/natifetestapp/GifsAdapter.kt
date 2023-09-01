package com.example.natifetestapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.natifetestapp.databinding.RvItemBinding

class GifsAdapter(
    private val onGifClick: (String) -> Unit
) : ListAdapter<GifItem, GifsAdapter.GifsViewHolder>(GifDiffCallback()) {

    class GifsViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(gifItem: GifItem, onGifClick: (String) -> Unit) {
            binding.ivGif.loadUrl(binding.root.context, gifItem.images.original.url)
            binding.root.setOnClickListener { onGifClick(gifItem.images.original.url) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifsViewHolder {
        val binding = RvItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GifsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GifsViewHolder, position: Int) {
        val gifItem = getItem(position)
        holder.bind(gifItem, onGifClick)
    }
}