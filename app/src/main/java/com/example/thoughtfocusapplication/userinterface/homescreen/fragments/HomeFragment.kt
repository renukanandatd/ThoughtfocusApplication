package com.example.thoughtfocusapplication.userinterface.homescreen.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.databinding.FragmentHomeBinding
import com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel.HomeViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var viewModel: HomeViewModel
    var homeBinding : FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        val binding = FragmentHomeBinding.bind(view)
        homeBinding = binding

        binding.cardView1.setOnClickListener {
            toggleVisibility(homeBinding!!.hiddenLayout1)
        }

        binding.cardView2
            .setOnClickListener {
            toggleVisibility(homeBinding!!.hiddenLayout2)
        }

        binding.cardView3.setOnClickListener {
            toggleVisibility(homeBinding!!.hiddenLayout3)
        }

        binding.cardView4.setOnClickListener {
            toggleVisibility(homeBinding!!.hiddenLayout4)
        }

    }

    private fun toggleVisibility(view: View) {
        if (view.visibility == View.VISIBLE) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
        }
    }
}