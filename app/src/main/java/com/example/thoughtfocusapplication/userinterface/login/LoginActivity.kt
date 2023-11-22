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
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        viewModel.username.observe(this,{username->

        })

        viewModel.password.observe(this,{password->

        })

        loginBinding.buttonSignIn.setOnClickListener {
            if( loginBinding.mid.text?.isEmpty()!!){
                Toast.makeText(this,"Enter your Merchant ID", Toast.LENGTH_LONG).show()
            }else if(loginBinding.textPassword.text?.isEmpty()!!){
                Toast.makeText(this,"Enter your password", Toast.LENGTH_LONG).show()
            }else if(loginBinding.textPassword.text?.length!! <10){
                Toast.makeText(this,"Password should be of minimum length 10", Toast.LENGTH_LONG).show()
            } else{
                val intent= Intent(this, MainActivity::class.java)
                //intent.putExtra(Constants.USER_NAME,inputText.text.toString())
                startActivity(intent)

            }
        }
    }
}