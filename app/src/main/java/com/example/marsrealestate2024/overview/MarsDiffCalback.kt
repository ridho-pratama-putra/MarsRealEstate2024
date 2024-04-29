package com.example.marsrealestate2024.overview

import androidx.recyclerview.widget.DiffUtil
import com.example.marsrealestate2024.network.MarsProperty

class MarsDiffCalback: DiffUtil.ItemCallback<MarsProperty>() {
    override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
//        Timber.i("areItemsTheSame ${oldItem.nightId} && ${newItem.nightId}")
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
//        Timber.i("areContentsTheSame ${oldItem.endTimeMilli} && ${newItem.endTimeMilli}")
        return oldItem == newItem
    }

}