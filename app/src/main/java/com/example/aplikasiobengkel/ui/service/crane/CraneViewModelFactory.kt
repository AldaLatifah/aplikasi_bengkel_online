package com.example.aplikasiobengkel.ui.service.crane

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasiobengkel.ui.service.repair.RepairViewModel
import com.example.aplikasiobengkel.ui.service.repair.RepairViewModelFactory
import java.lang.IllegalArgumentException

class CraneViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var INSTANCE: CraneViewModelFactory? = null
        @JvmStatic
        fun getInstance(application: Application): CraneViewModelFactory {
            if (INSTANCE == null) {
                synchronized(CraneViewModelFactory::class.java) {
                    INSTANCE = CraneViewModelFactory(application)
                }
            }
            return INSTANCE as CraneViewModelFactory
        }
    }

    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CraneViewModel::class.java)) {
            return CraneViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}