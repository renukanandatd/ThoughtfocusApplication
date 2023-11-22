package com.example.thoughtfocusapplication.userinterface.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.thoughtfocusapplication.R
import com.example.thoughtfocusapplication.userinterface.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 2000 // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Post a delayed action to open the NextActivity after splashTimeOut
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // close the splash activity so it can't be returned to
        }, splashTimeOut)
    }
}