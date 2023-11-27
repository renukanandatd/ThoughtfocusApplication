package com.example.thoughtfocusapplication.userinterface.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.databinding.ActivityLoginBinding
import com.example.thoughtfocusapplication.userinterface.homescreen.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel : LoginViewModel
    lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = loginBinding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // Observe changes in the authentication status
        viewModel.isAuthenticated.observe(this) { isAuthenticated ->
            if (isAuthenticated) {
                val intent= Intent(this, MainActivity::class.java)
                //intent.putExtra(Constants.USER_NAME,inputText.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this,"Enter your Username and password correctly", Toast.LENGTH_LONG).show()
                println("Authentication failed!")
            }
        }

        loginBinding.buttonSignIn.setOnClickListener {
            // Set the username and password in the ViewModel
            viewModel.setUsername(loginBinding.mid.text.toString())
            viewModel.setPassword(loginBinding.textPassword.text.toString())

            // Trigger authentication
            viewModel.authenticate()
        }
    }
    }
