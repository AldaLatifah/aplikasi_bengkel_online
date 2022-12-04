package com.example.aplikasiobengkel.ui.profile.update

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModel
import com.example.aplikasiobengkel.ui.auth.login.LoginViewModelFactory
import java.lang.IllegalArgumentException

class ChangeProfileViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var INSTANCE: ChangeProfileViewModelFactory? = null
        @JvmStatic
        fun getInstance(application: Application): ChangeProfileViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ChangeProfileViewModelFactory::class.java) {
                    INSTANCE = ChangeProfileViewModelFactory(application)
                }
            }
            return INSTANCE as ChangeProfileViewModelFactory
        }
    }

    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ChangeProfileViewModel::class.java)) {
            return ChangeProfileViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}