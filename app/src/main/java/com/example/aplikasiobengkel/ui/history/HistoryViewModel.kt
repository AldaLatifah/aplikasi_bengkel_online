package com.example.aplikasiobengkel.ui.history

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.Repair
import com.example.aplikasiobengkel.data.repository.CraneRepository
import com.example.aplikasiobengkel.data.repository.RepairRepository

class HistoryViewModel (application: Application) : ViewModel(){

    private val mCraneRepository: CraneRepository = CraneRepository(application)
    private val mRepairRepository: RepairRepository = RepairRepository(application)

    fun getAllCrane(): LiveData<List<Crane>> = mCraneRepository.getAllCranes()
    fun getAllRepair(): LiveData<List<Repair>> = mRepairRepository.getAllRepairs()
}