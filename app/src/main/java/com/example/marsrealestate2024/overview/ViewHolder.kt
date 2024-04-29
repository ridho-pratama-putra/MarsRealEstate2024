package com.example.marsrealestate2024.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marsrealestate2024.databinding.GridViewItemBinding
import com.example.marsrealestate2024.network.MarsProperty
import timber.log.Timber

/**
 * biolerplate code copas dari arch data layer, hanya ganti param item sama click listener
 */
class ViewHolder private constructor(private val binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        item: MarsProperty,
        clickListener: ItemClickListener
    ) {
        binding.marsProperty = item
        binding.clickListener = clickListener
        /**
         * memastikan bahwa semua perubahan data pada setiap item di RecyclerView telah diterapkan ke tampilan
         * sebelum item tersebut ditampilkan kepada pengguna.
         */
        binding.executePendingBindings()
    }

    companion object {
        fun from (parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = GridViewItemBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(view)
        }
    }
}