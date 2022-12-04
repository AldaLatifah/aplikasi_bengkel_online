package com.example.aplikasiobengkel.ui.chat

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.data.repository.ChatRepository
import com.example.aplikasiobengkel.data.repository.UserRepository
import kotlinx.coroutines.launch

class ChatViewModel(application: Application) : ViewModel() {
    private val repository: ChatRepository = ChatRepository(application)
    private var _account = MutableLiveData<Chat?>()
    val account get() = _account

    fun getAllChat(name: String): LiveData<List<Chat>> = repository.getAllChat(name)
    fun getAllMessage(): LiveData<List<Chat>> = repository.getAllMessage()

    fun insert(chat: Chat) {
        viewModelScope.launch {
            repository.insert(chat)
        }
    }

    fun delete(name:String){
        viewModelScope.launch {
            repository.delete(name)
        }
    }

}