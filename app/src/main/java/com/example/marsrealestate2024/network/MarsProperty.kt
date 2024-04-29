package com.example.marsrealestate2024.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
class MarsProperty(
    val id: Long,
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        other as MarsProperty
        return price == other?.price && imgSrcUrl == other.imgSrcUrl && type == other.type
    }
}