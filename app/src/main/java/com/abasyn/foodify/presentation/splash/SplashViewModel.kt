package com.abasyn.foodify.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _events = MutableSharedFlow<SplashEvents>()
    val event: SharedFlow<SplashEvents> = _events

    init {
        navigateToLogin()
    }
    private fun navigateToLogin() =  viewModelScope.launch{
        delay(2000)
        _events.emit(
            SplashEvents.NavigateToLogin
        )
    }
    sealed class SplashEvents{
        data object NavigateToLogin : SplashEvents()

    }
}