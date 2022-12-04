package com.example.aplikasiobengkel.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.aplikasiobengkel.data.database.OBengkelDatabase
import com.example.aplikasiobengkel.data.database.dao.ChatDao
import com.example.aplikasiobengkel.data.database.dao.CraneDao
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ChatRepository(application: Application) {
    private val chatDao: ChatDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = OBengkelDatabase.getDatabase(application)
        chatDao = db.chatDao()
    }

    suspend fun insert(chat: Chat) = withContext(Dispatchers.IO){
        chatDao.insert(chat)
    }

    suspend fun getIntentionName(name:String) : Chat? = withContext(Dispatchers.IO){
        chatDao.getIntentionChat(name)
    }

    fun getAllChat(name:String): LiveData<List<Chat>> = chatDao.getAllChat(name)

    fun getAllMessage(): LiveData<List<Chat>> = chatDao.getAllMessage()

    suspend fun delete(name:String) = withContext(Dispatchers.IO){
        chatDao.deleteByName(name)
    }
}