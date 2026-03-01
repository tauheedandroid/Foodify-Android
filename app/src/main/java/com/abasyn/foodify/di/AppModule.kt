package com.abasyn.foodify.di


import com.abasyn.foodify.presentation.home.HomeViewModel
import com.abasyn.foodify.presentation.login.LoginViewModel
import com.abasyn.foodify.presentation.next.NextViewModel
import com.abasyn.foodify.presentation.signup.SignUpViewModel
import com.abasyn.foodify.presentation.splash.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        SplashViewModel()
    }
    viewModel {
        LoginViewModel()
    }
    viewModel {
        SignUpViewModel()
    }
    viewModel {
        HomeViewModel()
    }
    viewModel {
        NextViewModel()
    }

}