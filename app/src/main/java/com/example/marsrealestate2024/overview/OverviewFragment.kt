package com.example.marsrealestate2024.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val binding: FragmentOverviewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false)
        val viewModelFactory = OverviewViewModelFactory()
        val overviewViewModel = ViewModelProvider(this, viewModelFactory).get(OverviewViewModel::class.java)
        binding.viewModel = overviewViewModel

        overviewViewModel.properties.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.restResponse.text = it.toString()
            }
        })
        return binding.root
    }
}