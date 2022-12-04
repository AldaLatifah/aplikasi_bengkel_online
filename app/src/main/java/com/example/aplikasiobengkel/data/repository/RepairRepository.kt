package com.example.aplikasiobengkel.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.aplikasiobengkel.data.database.OBengkelDatabase
import com.example.aplikasiobengkel.data.database.dao.RepairDao
import com.example.aplikasiobengkel.data.database.dao.UserDao
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.Repair
import com.example.aplikasiobengkel.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class RepairRepository (application: Application)  {
    private val repairDao: RepairDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = OBengkelDatabase.getDatabase(application)
        repairDao = db.repairDao()
    }

    suspend fun insertData(repair: Repair) = withContext(Dispatchers.IO){
        repairDao.insert(repair)
    }

    fun getAllRepairs(): LiveData<List<Repair>> = repairDao.getAllRepairs()

    suspend fun getMontirName(name:String) : Repair? = withContext(Dispatchers.IO){
        repairDao.getMontirName(name)
    }
}