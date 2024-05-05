package com.example.marsrealestate2024.overview

import com.example.marsrealestate2024.network.MarsProperty

class ItemClickListener (val clickListener: (itemId: Long) -> Unit) {
    fun onClickItem(item: MarsProperty) = clickListener(item.id)
    fun onClickItem(id: Long) = clickListener(id)
}