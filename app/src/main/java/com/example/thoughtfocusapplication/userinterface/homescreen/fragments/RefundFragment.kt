package com.example.thoughtfocusapplication.userinterface.homescreen.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel.RefundViewModel

class RefundFragment : Fragment(R.layout.fragment_refund) {

    companion object {
        fun newInstance() = RefundFragment()
    }

    private lateinit var viewModel: RefundViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_refund, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RefundViewModel::class.java)
        // TODO: Use the ViewModel
    }

}