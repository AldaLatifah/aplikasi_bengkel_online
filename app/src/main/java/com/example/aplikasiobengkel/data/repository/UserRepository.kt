package com.example.aplikasiobengkel.data.repository

import android.app.Application
import com.example.aplikasiobengkel.data.database.OBengkelDatabase
import com.example.aplikasiobengkel.data.database.dao.UserDao
import com.example.aplikasiobengkel.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class UserRepository(application: Application)  {
    private val userDao: UserDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = OBengkelDatabase.getDatabase(application)
        userDao = db.userDao()
    }

    suspend fun insert(user: User) = withContext(Dispatchers.IO){
        userDao.insert(user)
    }

    suspend fun getUsername(email:String) : User? = withContext(Dispatchers.IO){
        userDao.getUsername(email)
    }

    suspend fun update(user: User) = withContext(Dispatchers.IO){
        userDao.update(user)
    }

     suspend fun updatePassword(email: String, password : String) = withContext(Dispatchers.IO){
        userDao.updatePassword(email, password)
         print(userDao.updatePassword(email, password))
    }



}