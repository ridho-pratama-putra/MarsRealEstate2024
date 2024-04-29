package com.example.marsrealestate2024.overview

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marsrealestate2024.network.MarsProperty

class MarsAdapter(val itemClickListener: ItemClickListener): ListAdapter<MarsProperty, RecyclerView.ViewHolder>(MarsDiffCalback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ViewHolder -> {
                val item = getItem(position) as MarsProperty
                holder.bind(item, itemClickListener)
            }
        }
    }

}