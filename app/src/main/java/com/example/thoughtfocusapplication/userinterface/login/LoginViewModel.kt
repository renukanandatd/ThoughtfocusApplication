package com.example.thoughtfocusapplication.userinterface.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username : LiveData<String> = _username

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    fun setUsername(newUsername : String){
        _username.value = newUsername
    }

    fun setPassword(newPassword : String){
        _password.value = newPassword
    }
}