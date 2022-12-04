package com.example.aplikasiobengkel.data.di

import android.app.Application
import android.content.Context
import com.example.aplikasiobengkel.data.database.OBengkelDatabase
import com.example.aplikasiobengkel.data.repository.RepairRepository

object Injection {
    fun provideRepairRepository(application: Application): RepairRepository {
        return RepairRepository(application)
    }
}