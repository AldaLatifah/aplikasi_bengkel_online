package com.example.aplikasiobengkel.ui.service.crane

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.User
import com.example.aplikasiobengkel.data.repository.ChatRepository
import com.example.aplikasiobengkel.data.repository.CraneRepository
import kotlinx.coroutines.launch

class CraneViewModel (application: Application) : ViewModel(){

    private val mCraneRepository: CraneRepository = CraneRepository(application)
    private val mChatRepository: ChatRepository = ChatRepository(application)

    private var _intentionname = MutableLiveData<Chat?>()
    val intentionname get() = _intentionname

    fun insertCraneData(crane: Crane) {
        viewModelScope.launch {
            mCraneRepository.insertData(crane)
        }
    }

    fun getAllCrane(): LiveData<List<Crane>> = mCraneRepository.getAllCranes()

    fun getIntentionName(name:String){
        viewModelScope.launch {
            _intentionname.value = mChatRepository.getIntentionName(name)
        }
    }

    fun insertChat(chat: Chat){
        viewModelScope.launch {
            mChatRepository.insert(chat)
        }
    }
}