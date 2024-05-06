package com.example.marsrealestate2024.overview

import com.example.marsrealestate2024.network.MarsProperty

class ItemClickListener (val clickListener: (itemId: MarsProperty) -> Unit) {
    fun onClickItem(item: MarsProperty) = clickListener(item)
}