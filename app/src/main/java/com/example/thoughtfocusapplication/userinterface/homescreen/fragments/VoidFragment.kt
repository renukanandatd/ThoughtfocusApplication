package com.example.thoughtfocusapplication.userinterface.homescreen.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel.VoidViewModel

class VoidFragment : Fragment() {

    companion object {
        fun newInstance() = VoidFragment()
    }

    private lateinit var viewModel: VoidViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_void, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VoidViewModel::class.java)
        // TODO: Use the ViewModel
    }

}