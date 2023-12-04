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
        successfulBinding.tvTypes.text = "Type"
        successfulBinding.tvAmt.text = "Amount"
        successfulBinding.tvDate.text = "Date"
        successfulBinding.tvTimes .text= "Time"
        sharedViewModel.transactionType.observe(viewLifecycleOwner, Observer {
            val type = it
            successfulBinding.tvType.text = type
        })
        sharedViewModel.amount.observe(viewLifecycleOwner, Observer {
            val amount = it
            successfulBinding.tvAmount.text = amount
        })
        sharedViewModel.date.observe(viewLifecycleOwner, Observer {
            val date = it
            successfulBinding.tvCurrentDate.text = date
        })
        sharedViewModel.time.observe(viewLifecycleOwner, Observer {
            val time = it
            successfulBinding.tvTime.text = time
        })
    }
}