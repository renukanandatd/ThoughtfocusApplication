package com.example.thoughtfocusapplication.userinterface.homescreen.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.databinding.FragmentSaleBinding
import com.example.thoughtfocusapplication.databinding.FragmentTransactionSuccessfulBinding
import com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel.SaleViewModel

class TransactionSuccessfulFragment : Fragment(R.layout.fragment_transaction_successful) {

    lateinit var successfulBinding: FragmentTransactionSuccessfulBinding

    private lateinit var sharedViewModel: SaleViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction_successful, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentTransactionSuccessfulBinding.bind(view)
        successfulBinding = binding

        // Initialize the ViewModel
        sharedViewModel = ViewModelProvider(requireActivity()).get(SaleViewModel::class.java)

        // Observe changes in the shared data
        sharedViewModel.sharedData.observe(viewLifecycleOwner, Observer {
            val amount = it
            successfulBinding.textView2.text = "Congratulations! your amount of $"+amount+" is sucessfully is credited"
        })
    }
}