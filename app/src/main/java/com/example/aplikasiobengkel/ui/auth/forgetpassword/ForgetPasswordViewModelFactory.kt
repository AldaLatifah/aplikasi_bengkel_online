package com.example.aplikasiobengkel.ui.auth.forgetpassword

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModel
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModelFactory
import java.lang.IllegalArgumentException

class ForgetPasswordViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var INSTANCE: ForgetPasswordViewModelFactory? = null
        @JvmStatic
        fun getInstance(application: Application): ForgetPasswordViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ForgetPasswordViewModelFactory::class.java) {
                    INSTANCE = ForgetPasswordViewModelFactory(application)
                }
            }
            return INSTANCE as ForgetPasswordViewModelFactory
        }
    }

    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ForgetPasswordViewModel::class.java)) {
            return ForgetPasswordViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}