package com.example.marsrealestate2024.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.marsrealestate2024.R
import com.example.marsrealestate2024.databinding.FragmentOverviewBinding

class OverviewFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // val binding: FragmentOverviewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false)
        val binding: FragmentOverviewBinding = FragmentOverviewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val viewModelFactory = OverviewViewModelFactory()
        val overviewViewModel = ViewModelProvider(this, viewModelFactory).get(OverviewViewModel::class.java)
        binding.viewModel = overviewViewModel

        val adapter = MarsAdapter(ItemClickListener { itemId -> Toast.makeText(context, "kipa", Toast.LENGTH_LONG).show() })
        binding.photosGridRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
    }
}