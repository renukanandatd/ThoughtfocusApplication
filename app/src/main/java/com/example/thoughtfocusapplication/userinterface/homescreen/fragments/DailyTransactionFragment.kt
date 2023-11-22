package com.example.thoughtfocusapplication.userinterface.homescreen.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel.DailyTransactionViewModel

class DailyTransactionFragment : Fragment() {

    companion object {
        fun newInstance() =
            DailyTransactionFragment()
    }

    private lateinit var viewModel: DailyTransactionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_daily_transaction, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DailyTransactionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}