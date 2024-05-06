package com.example.marsrealestate2024.detail

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.marsrealestate2024.R
import com.example.marsrealestate2024.databinding.FragmentDetailBinding
import com.example.marsrealestate2024.network.MarsProperty

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        val selectedProperty = DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val detailViewModelFactory = DetailViewModelFactory(selectedProperty, application)
        val detailViewModel = ViewModelProvider(this, detailViewModelFactory).get(DetailViewModel::class.java)
        binding.detailViewModel = detailViewModel

        return binding.root
    }
}