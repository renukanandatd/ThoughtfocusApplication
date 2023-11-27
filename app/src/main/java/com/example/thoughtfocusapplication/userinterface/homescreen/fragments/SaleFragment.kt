package com.example.thoughtfocusapplication.userinterface.homescreen.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.databinding.FragmentHomeBinding
import com.example.thoughtfocusapplication.databinding.FragmentSaleBinding
import com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel.SaleViewModel

class SaleFragment : Fragment(R.layout.fragment_sale) {

    private lateinit var viewModel: SaleViewModel
    lateinit var salebinding: FragmentSaleBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SaleViewModel::class.java)

        val transaction = childFragmentManager.beginTransaction()
        val binding = FragmentSaleBinding.bind(view)
        salebinding = binding

        /*binding.verifyButton.setOnClickListener {


            // Replace the existing fragment with the new one
            transaction.replace(R.id.fragmentContainer, HomeFragment())

            // Add the transaction to the back stack (optional)
            transaction.addToBackStack(null)

            // Commit the transaction
            transaction.commit()
        }*/
    }
}