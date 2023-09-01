package com.example.natifetestapp

import androidx.recyclerview.widget.DiffUtil

class GifDiffCallback : DiffUtil.ItemCallback<GifItem>() {
    override fun areItemsTheSame(oldItem: GifItem, newItem: GifItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GifItem, newItem: GifItem): Boolean {
        return oldItem == newItem
    }
}