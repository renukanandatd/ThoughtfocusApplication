package com.example.thoughtfocusapplication.userinterface.homescreen.fragments

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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

        salebinding.verifyButton.setOnClickListener {
            val dataToSend = salebinding.editTextNumber.text.toString()
            viewModel.sharedData.value = dataToSend
            showAlertDialog()
        }

        /*binding.verifyButton.setOnClickListener {


            // Replace the existing fragment with the new one
            transaction.replace(R.id.fragmentContainer, HomeFragment())

            // Add the transaction to the back stack (optional)
            transaction.addToBackStack(null)

            // Commit the transaction
            transaction.commit()
        }*/
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Select Pyment Type")

        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.alert_dialog, null)
        builder.setView(dialogView)

        val radioButton1: RadioButton = dialogView.findViewById(R.id.radioButton1)
        val radioButton2: RadioButton = dialogView.findViewById(R.id.radioButton2)
        val radioButton3: RadioButton = dialogView.findViewById(R.id.radioButton3)

        builder.setPositiveButton("OK") { dialog, _ ->
            // Handle selection here
            when {
                radioButton1.isChecked -> navigateToFragment(TransactionSuccessfulFragment())
                radioButton2.isChecked -> navigateToFragment(TransactionSuccessfulFragment())
                radioButton3.isChecked -> navigateToFragment(TransactionSuccessfulFragment())
            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        val alertDialog = builder.create()

        // Set the dialog width and height to fill the screen
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        alertDialog.window?.setLayout(width, height)

        alertDialog.show()
    }
    private fun navigateToFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null) // Optional: Adds the transaction to the back stack
        transaction.commit()
}}