package com.example.thoughtfocusapplication.userinterface.adapters

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.databinding.FragmentLoaderBinding
import com.example.thoughtfocusapplication.databinding.HistoryLayoutRecyclerViewBinding
import com.example.thoughtfocusapplication.roomdb.entity.TransactionDetailsEntity

class ItemAdapter(private val items: ArrayList<TransactionDetailsEntity>,
                            //private val deleteListener: (id:Int)->Unit
):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(binding: HistoryLayoutRecyclerViewBinding):RecyclerView.ViewHolder(binding.root){
        val history = binding.history
        val types = binding.tvTypes
        val type = binding.tvType
        val amt = binding.tvAmt
        val amount = binding.tvAmount
        val dates = binding.tvDate
        val date = binding.tvCurrentDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(HistoryLayoutRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val items = items[position]

        holder.types.text = "Type"
        holder.type.text = items.type
        holder.amt.text = "Amount"
        holder.amount.text = items.amount
        holder.dates.text = "Date"
        holder.date.text = items.date

        if(position%2==0){
            holder.history.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.lightgreen))
        }else{
            holder.history.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.white))
        }
    }
}