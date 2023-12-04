package com.example.thoughtfocusapplication.userinterface.homescreen.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.ProgressBar
import android.widget.VideoView
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.databinding.FragmentLoaderBinding
import com.example.thoughtfocusapplication.userinterface.homescreen.viewmodel.LoaderViewModel

class LoaderFragment : Fragment() {
    private var progressStatus = 0
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var binding: FragmentLoaderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar: ProgressBar = binding.progressBar

        Thread(Runnable {
            while (progressStatus < 100) {
                activity?.runOnUiThread {
                    progressBar.progress = progressStatus
                }

                try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                progressStatus++
            }

            handler.postDelayed({
                navigateToFragment(TransactionSuccessfulFragment())
            }, 500)
        }).start()
    }

    private fun navigateToFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}