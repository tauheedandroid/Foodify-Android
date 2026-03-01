package com.abasyn.foodify.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abasyn.foodify.data.UserSession

class LoginViewModel : ViewModel() {

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    fun login(email: String, password: String) {

        val savedEmail = UserSession.email
        val savedPassword = UserSession.password

        if (email == savedEmail && password == savedPassword) {
            _loginSuccess.value = true
        } else {
            _loginSuccess.value = false
        }
    }
}