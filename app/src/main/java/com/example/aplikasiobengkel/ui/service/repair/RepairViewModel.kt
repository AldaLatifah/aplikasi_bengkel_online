package com.example.aplikasiobengkel.ui.service.repair

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasiobengkel.data.model.Chat
import com.example.aplikasiobengkel.data.model.Crane
import com.example.aplikasiobengkel.data.model.Repair
import com.example.aplikasiobengkel.data.repository.ChatRepository
import com.example.aplikasiobengkel.data.repository.RepairRepository
import kotlinx.coroutines.launch

class RepairViewModel(application: Application) : ViewModel(){

    private val mRepairRepository: RepairRepository = RepairRepository(application)
    private val mChatRepository: ChatRepository = ChatRepository(application)

    private var _montirname = MutableLiveData<Repair?>()
    val montirname get() = _montirname

    private var _intentionname = MutableLiveData<Chat?>()
    val intentionname get() = _intentionname

    fun insertRepairData(repair: Repair) {
        viewModelScope.launch {
            mRepairRepository.insertData(repair)
        }
    }

    fun getMontirName(name:String){
        viewModelScope.launch {
            _montirname.value = mRepairRepository.getMontirName(name)
        }
    }

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