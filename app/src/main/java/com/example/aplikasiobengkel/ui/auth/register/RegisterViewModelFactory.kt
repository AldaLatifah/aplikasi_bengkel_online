package com.example.aplikasiobengkel.ui.auth.register

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModel
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModelFactory
import java.lang.IllegalArgumentException

class RegisterViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var INSTANCE: RegisterViewModelFactory? = null
        @JvmStatic
        fun getInstance(application: Application): RegisterViewModelFactory {
            if (INSTANCE == null) {
                synchronized(RegisterViewModelFactory::class.java) {
                    INSTANCE = RegisterViewModelFactory(application)
                }
            }
            return INSTANCE as RegisterViewModelFactory
        }
    }

    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}