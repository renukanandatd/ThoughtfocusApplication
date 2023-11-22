package com.example.thoughtfocusapplication.userinterface.homescreen.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel.MonthlyTransactionViewModel

class MonthlyTransactionFragment : Fragment() {

    companion object {
        fun newInstance() = MonthlyTransactionFragment()
    }

    private lateinit var viewModel: MonthlyTransactionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_monthly_transaction, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MonthlyTransactionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}