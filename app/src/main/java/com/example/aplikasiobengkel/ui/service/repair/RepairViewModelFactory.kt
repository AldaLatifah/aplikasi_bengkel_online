package com.example.aplikasiobengkel.ui.service.repair

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.ui.auth.register.RegisterViewModel
import com.example.aplikasiobengkel.ui.auth.register.RegisterViewModelFactory
import java.lang.IllegalArgumentException

class RepairViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var INSTANCE: RepairViewModelFactory? = null
        @JvmStatic
        fun getInstance(application: Application): RepairViewModelFactory {
            if (INSTANCE == null) {
                synchronized(RepairViewModelFactory::class.java) {
                    INSTANCE = RepairViewModelFactory(application)
                }
            }
            return INSTANCE as RepairViewModelFactory
        }
    }

    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RepairViewModel::class.java)) {
            return RepairViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}