package com.example.aplikasiobengkel.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.aplikasiobengkel.data.database.OBengkelDatabase
import com.example.aplikasiobengkel.data.database.dao.CraneDao
import com.example.aplikasiobengkel.data.database.dao.RepairDao
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.Repair
import com.example.aplikasiobengkel.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CraneRepository(application: Application) {

    private val craneDao: CraneDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = OBengkelDatabase.getDatabase(application)
        craneDao = db.craneDao()
    }

    suspend fun insertData(crane: Crane) = withContext(Dispatchers.IO){
        craneDao.insert(crane)
    }

    fun getAllCranes(): LiveData<List<Crane>> = craneDao.getAllCranes()

    suspend fun getBengkelName(name:String) : Crane? = withContext(Dispatchers.IO){
        craneDao.getBengkelName(name)
    }
}