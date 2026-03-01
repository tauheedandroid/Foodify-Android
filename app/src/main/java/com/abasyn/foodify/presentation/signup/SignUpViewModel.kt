package com.abasyn.foodify.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abasyn.foodify.data.UserSession

class SignUpViewModel : ViewModel() {

    private val _signUpSuccess = MutableLiveData<Boolean>()
    val signUpSuccess: LiveData<Boolean> = _signUpSuccess

    fun signUp(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {

            UserSession.email = email.trim()
            UserSession.password = password.trim()

            _signUpSuccess.value = true
        } else {
            _signUpSuccess.value = false
        }
    }
}