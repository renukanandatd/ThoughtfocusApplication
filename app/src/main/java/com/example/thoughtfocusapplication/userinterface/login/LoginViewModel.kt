package com.example.thoughtfocusapplication.userinterface.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
        private val _username = MutableLiveData<String>()
        val username: LiveData<String> = _username

        private val _password = MutableLiveData<String>()
        val password: LiveData<String> = _password

        private val _isAuthenticated = MutableLiveData<Boolean>()
        val isAuthenticated: LiveData<Boolean> = _isAuthenticated

        fun setUsername(newUsername: String) {
            _username.value = newUsername
        }

        fun setPassword(newPassword: String) {
            _password.value = newPassword
        }

        fun authenticate() {
            val isAuthenticated = !_username.value.isNullOrBlank() && !_password.value.isNullOrBlank()
            _isAuthenticated.value = isAuthenticated
        }
    }

