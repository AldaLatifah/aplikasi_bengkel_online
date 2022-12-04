package com.example.aplikasiobengkel.ui.profile

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.ui.service.crane.CraneViewModel
import java.lang.IllegalArgumentException

class ProfileViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var INSTANCE: ProfileViewModelFactory? = null
        @JvmStatic
        fun getInstance(application: Application): ProfileViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ProfileViewModelFactory::class.java) {
                    INSTANCE = ProfileViewModelFactory(application)
                }
            }
            return INSTANCE as ProfileViewModelFactory
        }
    }

    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}