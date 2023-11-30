package com.example.thoughtfocusapplication.userinterface.homescreen.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.databinding.FragmentSaleBinding
import com.example.thoughtfocusapplication.databinding.FragmentTransactionHistoryBinding
import com.example.thoughtfocusapplication.roomdb.TransactionApp
import com.example.thoughtfocusapplication.roomdb.dao.TransactionDetailsDAO
import com.example.thoughtfocusapplication.roomdb.entity.TransactionDetailsEntity
import com.example.thoughtfocusapplication.userinterface.adapters.ItemAdapter
import com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel.SaleViewModel
import com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel.TransactionHistoryViewModel
import kotlinx.coroutines.launch

class TransactionHistoryFragment : Fragment(R.layout.fragment_transaction_history) {

    lateinit var historybinding: FragmentTransactionHistoryBinding
    private lateinit var viewModel: TransactionHistoryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var binding = FragmentTransactionHistoryBinding.bind(view)
        historybinding = binding

        viewModel =
            ViewModelProvider(requireActivity()).get(TransactionHistoryViewModel::class.java)
        val application = requireActivity().application
        val transactionDetailsDAO = (application as TransactionApp).db.transactionDAO()
        lifecycleScope.launch {
            transactionDetailsDAO.fetchAllTransactionDetails().collect{
                val list = ArrayList(it)
                setupListOfDataIntoRecyclerView(list,transactionDetailsDAO)
            }
        }

    }

    private fun setupListOfDataIntoRecyclerView(transactionList:ArrayList<TransactionDetailsEntity>,
                                                transactionDetailsDAO: TransactionDetailsDAO
    ) {
        if (transactionList.isNotEmpty()) {
            val itemAdapter = ItemAdapter(
                transactionList

            )
            historybinding.rvItemsList.layoutManager = LinearLayoutManager(context)
            historybinding.rvItemsList.adapter = itemAdapter
            historybinding.rvItemsList.visibility = View.VISIBLE
            historybinding.textView3.visibility = View.GONE
        }
        else{
            historybinding.rvItemsList.visibility = View.GONE
            historybinding.textView3.visibility = View.VISIBLE
        }
    }
}