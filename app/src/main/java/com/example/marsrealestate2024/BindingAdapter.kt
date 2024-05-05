package com.example.marsrealestate2024

import android.opengl.Visibility
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.marsrealestate2024.network.MarsApiStatus
import com.example.marsrealestate2024.network.MarsProperty
import com.example.marsrealestate2024.overview.MarsAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.ic_broken_image)
                .error(R.drawable.ic_broken_image))
            .into(imgView)

    }
}

/**
 * help direct observe from viewmoodel to layout
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsProperty>? ) {
    val adapter = recyclerView.adapter as MarsAdapter
    adapter.submitList(data)
}

@BindingAdapter("loadingStatus")
fun bindLoadingStatus(loadingStatusImageView: ImageView, status: MarsApiStatus) {
    when(status) {
        MarsApiStatus.LOADING -> {
            loadingStatusImageView.visibility = View.VISIBLE
            loadingStatusImageView.setImageResource(R.drawable.loading_animation)
        }

        MarsApiStatus.DONE -> {
            loadingStatusImageView.visibility = View.GONE
        }

        MarsApiStatus.ERROR -> {
            loadingStatusImageView.visibility = View.VISIBLE
            loadingStatusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}
