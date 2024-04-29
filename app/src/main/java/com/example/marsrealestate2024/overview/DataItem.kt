package com.example.marsrealestate2024.overview
//
//import com.example.marsrealestate2024.network.MarsProperty
//
//sealed class DataItem {
//    abstract val id: Long
//    data class MarsDataItem(val marsApiProperty: MarsProperty): DataItem() {
//        override val id: Long
//            get() = marsApiProperty.id
//    }
//
//    object Header: DataItem() {
//        override val id: Long
//            get() = Long.MIN_VALUE
//    }
//}